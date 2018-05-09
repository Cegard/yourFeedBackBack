package com.backend.technicalchallenge.model.evaluation;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.user.UserApp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "user_id"}))
public class EvaluatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Event event;
    @ManyToOne
    private UserApp userApp;
    @JsonIgnore
    @OneToMany(mappedBy = "evaluatedUser")
    private List<Evaluation> evaluations;



}
