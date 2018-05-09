package com.backend.technicalchallenge.model.evaluation;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
public class GroupComment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;
    private String note;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Evaluation evaluation;
    @ManyToOne
    private GroupApp groupApp;
}
