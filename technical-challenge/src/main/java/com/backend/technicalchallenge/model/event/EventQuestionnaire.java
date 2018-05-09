package com.backend.technicalchallenge.model.event;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(uniqueConstraints =  @UniqueConstraint(columnNames = {"questionnaire_id", "event_id"}))
public class EventQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Questionnaire questionnaire;
    @ManyToOne
    private Event event;


}
