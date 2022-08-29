package it.bitrock.mongodbstart.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AwardsDTO {

    private Integer wins;
    private Integer nominations;
    private String text;
}
