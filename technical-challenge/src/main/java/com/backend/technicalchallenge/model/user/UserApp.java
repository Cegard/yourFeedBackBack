package com.backend.technicalchallenge.model.user;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Accessors(chain = true)
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private int document;
    private String name;
    private String lastName;
    private String gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private DocumentType documentType;
    @ManyToOne
    private Role role;
    @ManyToOne
    private Area area;
    @JsonIgnore
    @OneToMany(mappedBy = "userApp")
    private List<EvaluatedUser> evaluatedUsers;
    @JsonIgnore
    @OneToMany(mappedBy = "userEvaluator")
    private List<Evaluation> evaluations;

}
