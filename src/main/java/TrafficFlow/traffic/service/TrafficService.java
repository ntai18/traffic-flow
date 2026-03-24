package TrafficFlow.traffic.service;

import TrafficFlow.traffic.model.dto.request.TrafficRequest;
import TrafficFlow.traffic.model.dto.response.TrafficResponse;

import java.util.List;

public interface TrafficService {
    List<TrafficResponse> getTraffic(Long roadId);
    TrafficResponse createTraffic(Long roadId, TrafficRequest trafficRequest);
    TrafficResponse updateTraffic(Long roadId, Long trafficId, TrafficRequest trafficRequest);
    void deleteTraffic(Long roadId, Long trafficId);
    List<TrafficResponse> getTrafficByRoad(Long roadId);
}
