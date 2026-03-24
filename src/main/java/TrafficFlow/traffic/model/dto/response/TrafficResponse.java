package TrafficFlow.traffic.model.dto.response;

import TrafficFlow.traffic.type.FrameTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficResponse {
    private Long Id;
    private Long roadId;
    @Enumerated(EnumType.STRING)
    private FrameTime frameTime;
    private Integer bicycles;
    private Integer motorbikes;
    private Integer cars;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
}
