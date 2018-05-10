package com.backend.technicalchallenge.model.questionnaire;


import com.backend.technicalchallenge.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String question;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private GroupApp groupApp;
    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<QuestionnaireQuestion> questionnaireQuestions;

}
