package com.backend.technicalchallenge.model.event;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Accessors(chain = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Date creationDate;
    @ManyToOne
    private Place place;
    @JsonIgnore
    @OneToMany (mappedBy = "event")
    private List<EventQuestionnaire> EventQuestionnaires;
    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<EvaluatedUser> evaluatedUsers;
    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<Evaluation> evaluations;

}
