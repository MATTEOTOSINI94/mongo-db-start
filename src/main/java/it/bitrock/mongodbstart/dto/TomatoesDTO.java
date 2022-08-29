package it.bitrock.mongodbstart.dto;

import it.bitrock.mongodbstart.model.Viewer;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TomatoesDTO {

    private ViewerDTO viewer;
    private LocalDateTime lastUpdated;
}
