package com.backend.technicalchallenge;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechnicalChallengeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		Assert.assertEquals(1,1);
	}

}
