package TrafficFlow.road.service;

import TrafficFlow.road.model.dto.request.RoadRequest;
import TrafficFlow.road.model.dto.response.RoadResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RoadService {
    List<RoadResponse> getRoad();
    RoadResponse createRoad(RoadRequest roadRequest);
    RoadResponse updateRoad(Long roadId, RoadRequest roadRequest);
    void deleteRoad(Long roadId);
    List<RoadResponse> searchRoad(@RequestBody RoadRequest roadRequest);

    boolean checkRoad(Long roadId);

    void updateFlowDay(Long roadId, Double flowDay);
}
