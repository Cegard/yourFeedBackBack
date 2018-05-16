package com.backend.technicalchallenge.model.DTO;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
public class GroupAppDTO {
    private Long id;
    private String name;
    private Long score;

}
