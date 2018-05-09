package com.backend.technicalchallenge.security;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.model.user.UserSession;
import org.apache.tomcat.util.codec.binary.Base64;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jwt.JWTClaimsSet;


public class Security {

    public static UserSession generateToken(UserApp u){
        // Generate secret key on runtime execution.
        KeyGenerator keyGen;
        try {
            keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();

            //store it in db sb.toString()
            byte[] byteAes = secretKey.getEncoded();
            String secretStore = Base64.encodeBase64String(byteAes);

            // Create the header
            JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256);

            Calendar calendar = Calendar.getInstance();
            // Prepare JWT with claims set
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(u.getEmail())
                    // token lasts a day
                    .expirationTime(new Date(calendar.getTimeInMillis() + (1000 * 86400)))
                    .build();

            // Set the payload
            Payload payload = new Payload(claimsSet.toJSONObject());

            // Create the JWE object and encrypt it
            JWEObject jweObject = new JWEObject(header, payload);
            jweObject.encrypt((JWEEncrypter) new DirectEncrypter(secretKey));
            String token = jweObject.serialize();
            UserSession us = new UserSession();
            us.setEmail(u.getEmail());
            us.setSecretKey(secretStore);
            us.setToken(token);
            return us;
        } catch (Exception e) {

            return null;
        }
    }

    public static boolean validateToken(String token,String secret){
        // Parse into JWE object again...
        SecretKey secretKey = convertSecretKey(secret);
        JWEObject jweObject;

        // Decrypt
        try {
            jweObject = JWEObject.parse(token);
            jweObject.decrypt(new DirectDecrypter(secretKey));
        } catch (Exception e) {

            return false;
        }

        // Get the plain text
        Payload payload = jweObject.getPayload();
        if(isExpired((Long)payload.toJSONObject().get("exp")))
            return false;

        return true;
    }

    public static String getSub(String token, String secret){
        SecretKey secretKey = convertSecretKey(secret);
        JWEObject jweObject;

        // Decrypt
        try {
            jweObject = JWEObject.parse(token);
            jweObject.decrypt(new DirectDecrypter(secretKey));
        } catch (Exception e) {

            return null;
        }

        Payload payload = jweObject.getPayload();
        return (String)payload.toJSONObject().get("sub");
    }

    private static boolean isExpired(long timestamp){
        return timestamp < (System.currentTimeMillis()/1000);
    }

    private static SecretKey convertSecretKey(String secretKey){
        // decode the base64 encoded string
        byte[] decodedKey = Base64.decodeBase64(secretKey);
        // rebuild key using SecretKeySpec
        SecretKey originalKey = new SecretKeySpec(decodedKey,  "HmacSHA256");
        return originalKey;
    }

}
