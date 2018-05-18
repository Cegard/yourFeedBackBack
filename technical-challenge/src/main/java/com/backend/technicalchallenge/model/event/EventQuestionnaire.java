package com.backend.technicalchallenge.model.event;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(uniqueConstraints =  @UniqueConstraint(columnNames = {"questionnaire_id", "event_id", "type"}))
public class EventQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnore
    @ManyToOne
    private Questionnaire questionnaire;
    @JsonIgnore
    @ManyToOne
    private Event event;


}
