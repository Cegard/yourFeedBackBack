package com.backend.technicalchallenge.model.questionnaire;

import com.backend.technicalchallenge.model.Status;
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
    private Status status;
    @ManyToOne
    private Questionnaire questionnaire;
    @ManyToOne Question question;
}
