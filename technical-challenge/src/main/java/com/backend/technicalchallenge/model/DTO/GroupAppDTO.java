package com.backend.technicalchallenge.model.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GroupAppDTO {
    Long id;
    String name;
    Long score;
}
