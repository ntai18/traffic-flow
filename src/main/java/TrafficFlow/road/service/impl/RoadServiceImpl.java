package TrafficFlow.road.service.impl;

import TrafficFlow.exception.AppException;
import TrafficFlow.exception.ErrorCode;
import TrafficFlow.road.mapper.RoadMapper;
import TrafficFlow.road.model.dto.request.RoadRequest;
import TrafficFlow.road.model.dto.response.RoadResponse;
import TrafficFlow.road.model.entity.Road;
import TrafficFlow.road.repository.RoadRepository;
import TrafficFlow.road.service.RoadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoadServiceImpl implements RoadService {
    private final RoadRepository roadRepository;
    private final RoadMapper roadMapper;





    @Override
    public List<RoadResponse> getRoad() {
        List<Road> roads = roadRepository.getRoads();
        List<RoadResponse> roadResponses = roadMapper.roadToRoadResponseList(roads);
        return roadResponses;
    }

    @Override
    public RoadResponse createRoad(RoadRequest roadRequest) {
        log.info("Creating road request {}", roadRequest);
        Road road = roadMapper.roadRequestToRoad(roadRequest);
        roadRepository.save(road);
        return roadMapper.road(road);
    }

    @Override
    public RoadResponse updateRoad(Long roadId, RoadRequest roadRequest) {
        Road road = roadRepository.getRoadId(roadId).orElseThrow(()-> new AppException(ErrorCode.ERR_001));
        roadMapper.roadUpdate(roadRequest, road);
        roadRepository.save(road);
        return roadMapper.road(road);
    }

    @Override
    public void deleteRoad(Long roadId) {
        Road road = roadRepository.getRoadId(roadId).orElseThrow(()-> new AppException(ErrorCode.ERR_001));
        roadRepository.delete(road);
    }

    @Override
    public List<RoadResponse> searchRoad(RoadRequest roadRequest) {
        List<Road> roads = roadRepository.searchRoad(roadRequest.getRoadType());
        log.info("Searching roads {}", roads);
        List<RoadResponse> roadResponses = roadMapper.roadToRoadResponseList(roads);
        return roadResponses;
    }

    @Override
    public boolean checkRoad(Long roadId) {
        Optional<Road> road = roadRepository.findById(roadId);
        return road.isPresent();
    }

    @Override
    public void updateFlowDay(Long roadId, Double flowDay) {

        log.info("Updating flow day {}", flowDay);
        Road road = roadRepository.getRoadId(roadId).orElseThrow(()-> new AppException(ErrorCode.ERR_001));
        road.setFlowDay(flowDay);
        roadRepository.save(road);
    }
}
