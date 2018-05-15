package com.backend.technicalchallenge.model.evaluation;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import com.backend.technicalchallenge.model.user.UserApp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)



@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Event event;
    @ManyToOne
    private UserApp userEvaluator;
    @ManyToOne
    private EvaluatedUser evaluatedUser;
    private String note;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
    @JsonIgnore
    @OneToMany(mappedBy = "evaluation")
    private List<Answer> answers;
    @JsonIgnore
    @OneToMany(mappedBy = "evaluation")
    private List<GroupComment> groupComments;

}
