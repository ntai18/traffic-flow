package TrafficFlow.traffic.model.dto.request;

import TrafficFlow.traffic.type.FrameTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficRequest {
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
