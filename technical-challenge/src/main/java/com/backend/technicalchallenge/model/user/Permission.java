package com.backend.technicalchallenge.model.user;

import com.backend.technicalchallenge.model.Status;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class Permission {
    @Accessors(chain = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Role role;
    private String controlle;
    private String action;
    private String permitted;
    @Enumerated(EnumType.STRING)
    private Status status;

}
