package com.backend.technicalchallenge.model.questionnaire;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Evaluation evaluation;
    @ManyToOne
    private Question question;

}
