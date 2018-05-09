package com.backend.technicalchallenge.model.event;


import com.backend.technicalchallenge.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnore
    @OneToMany(mappedBy = "place")
    private List<Event> events;

}
