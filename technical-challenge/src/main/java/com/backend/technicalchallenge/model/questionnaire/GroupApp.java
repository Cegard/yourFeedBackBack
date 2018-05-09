package com.backend.technicalchallenge.model.questionnaire;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.evaluation.GroupComment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class GroupApp {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnore
    @OneToMany(mappedBy = "groupApp")
    private List<Question> questions;
    @JsonIgnore
    @OneToMany(mappedBy = "groupApp")
    private List<GroupComment> groupComments;


}
