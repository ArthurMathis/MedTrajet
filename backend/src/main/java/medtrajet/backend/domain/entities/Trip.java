package medtrajet.backend.domain.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    private Long id;
    private Long userId;
    private Long destinationId;
    private Long startMileage;
    private Long endMileage;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
