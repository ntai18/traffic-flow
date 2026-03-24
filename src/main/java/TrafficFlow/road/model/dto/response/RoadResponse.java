package TrafficFlow.road.model.dto.response;

import TrafficFlow.road.type.RoadType;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class RoadResponse {
    @Enumerated(EnumType.STRING)
    private RoadType roadType;
    private String roadName;
    private double flowDay;
    private double flowDesign;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
}
