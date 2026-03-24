package TrafficFlow.road.model.entity;

import TrafficFlow.road.type.RoadType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "road")
@Getter
@Setter
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoadType roadType;

    private String roadName;
    @Column(name = "flow_day")
    private Double flowDay;
    @Column(name = "flow_design")
    private Double flowDesign;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

}
