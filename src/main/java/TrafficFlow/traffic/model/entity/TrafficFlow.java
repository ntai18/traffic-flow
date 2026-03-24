package TrafficFlow.traffic.model.entity;


import TrafficFlow.traffic.type.FrameTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "traffic_flow")
@Getter
@Setter
public class TrafficFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "road_id")
    private Long roadId;

    @Enumerated(EnumType.STRING)
    @NonNull
    private FrameTime frameTime;

    private Integer bicycles;
    private Integer motorbikes;
    private Integer cars;

    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NonNull
    private LocalDate date;

}

