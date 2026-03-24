package TrafficFlow.road.model.dto.request;

import TrafficFlow.road.type.RoadType;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class RoadRequest {

    private RoadType roadType;
    private String roadName;
    private Double flowDesign;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
}
