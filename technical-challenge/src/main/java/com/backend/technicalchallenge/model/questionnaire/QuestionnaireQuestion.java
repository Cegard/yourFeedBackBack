package com.backend.technicalchallenge.model.questionnaire;

import com.backend.technicalchallenge.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
public class QuestionnaireQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Questionnaire questionnaire;
    @ManyToOne
    private Question question;
}
