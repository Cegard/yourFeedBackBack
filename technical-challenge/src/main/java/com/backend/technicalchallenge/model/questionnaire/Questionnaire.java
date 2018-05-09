package com.backend.technicalchallenge.model.questionnaire;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.event.EventQuestionnaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String description;
    //It's written on database as 'note'
    private String furtherComments;
    private Type type;
    private Date creationDate;
    private Status status;
    @JsonIgnore
    @OneToMany(mappedBy = "questionnaire")
    private List<EventQuestionnaire> eventQuestionnaires;
    @JsonIgnore
    @OneToMany(mappedBy = "questionnaire")
    private List<QuestionnaireQuestion> questionnaireQuestions;
}
