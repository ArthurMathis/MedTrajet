package medtrajet.backend.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "trips")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJPA user;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private DestinationJPA destination;

    @Column(nullable = false)
    private Long startMileage;

    @Column()
    private Long endMileage;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime startedAt;

    @UpdateTimestamp
    @Column(name = "ended_at")
    private LocalDateTime endedAt;

}
