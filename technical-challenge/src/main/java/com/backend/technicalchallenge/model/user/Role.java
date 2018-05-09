package com.backend.technicalchallenge.model.user;

import com.backend.technicalchallenge.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<UserApp> userApp;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Permission> permission;
}
