package TrafficFlow.traffic.service.impl;

import TrafficFlow.exception.AppException;
import TrafficFlow.exception.ErrorCode;
import TrafficFlow.road.service.RoadService;
import TrafficFlow.traffic.mapper.TrafficMapper;
import TrafficFlow.traffic.model.dto.request.TrafficRequest;
import TrafficFlow.traffic.model.dto.response.TrafficResponse;
import TrafficFlow.traffic.model.entity.TrafficFlow;
import TrafficFlow.traffic.repository.TrafficRepository;
import TrafficFlow.traffic.service.TrafficService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrafficServiceImpl implements TrafficService {
    private final TrafficRepository trafficRepository;
    private final TrafficMapper trafficMapper;
    private final RoadService roadService;

    @Override
    public List<TrafficResponse> getTraffic(Long roadId) {
        List<TrafficFlow> trafficFlowList = trafficRepository.getTrafficRoad(roadId);
        if (trafficFlowList.isEmpty())
            throw new AppException(ErrorCode.ERR_003);
        return trafficMapper.trafficToTrafficResponseList(trafficFlowList);
    }

    @Override
    public TrafficResponse createTraffic(Long roadId, TrafficRequest trafficRequest) {
        if(!(roadService.checkRoad(roadId)))
            throw new AppException(ErrorCode.ERR_003);
        TrafficFlow trafficFlow = trafficRepository.checkTraffic(roadId, trafficRequest.getDate(),
                                                                 trafficRequest.getFrameTime());
        if (trafficFlow != null)
            throw new AppException(ErrorCode.ERR_003);
        TrafficFlow trafficFlowNew = trafficMapper.trafficRequestToTrafficCreate(trafficRequest, roadId);
        trafficRepository.save(trafficFlowNew);

        roadService.updateFlowDay(roadId, flowDay(roadId, trafficRequest.getDate()));
        return trafficMapper.trafficToTrafficResponse(trafficFlowNew);
    }

    @Override
    public TrafficResponse updateTraffic(Long roadId, Long trafficId, TrafficRequest trafficRequest) {
        log.info("updateTraffic");
        if(!(roadService.checkRoad(roadId)))
            throw new AppException(ErrorCode.ERR_003);
        TrafficFlow trafficFlow = trafficRepository.findById(trafficId).orElseThrow(()-> new AppException(ErrorCode.ERR_003));
        trafficMapper.updateTraffic(trafficRequest,trafficFlow);
        trafficRepository.save(trafficFlow);
        Double flowDays = flowDay(roadId, trafficRequest.getDate());
        roadService.updateFlowDay(roadId, flowDays);
        log.info("updateTraffic");
        return trafficMapper.trafficToTrafficResponse(trafficFlow);
    }


    private Double flowDay(Long roadId, LocalDate date){
        List<TrafficFlow> trafficFlowList = trafficRepository.getTrafficToRoadOneDay(roadId, date);
        Double flowDay = 0.0;
        for (TrafficFlow flow : trafficFlowList) {
            Double traf = (flow.getCars()*0.2)+(flow.getBicycles()*0.5)+(flow.getMotorbikes()*0.7);
            flowDay =+ traf;
        }
        log.info("flowDay={}",flowDay);
        return flowDay;
    }

    @Override
    public void deleteTraffic(Long roadId, Long trafficId) {
        if(!(roadService.checkRoad(roadId)))
            throw new AppException(ErrorCode.ERR_003);
        TrafficFlow trafficFlow = trafficRepository.deleteTraffic(roadId, trafficId).orElseThrow(()-> new AppException(ErrorCode.ERR_003));
        trafficRepository.delete(trafficFlow);

    }

    @Override
    public List<TrafficResponse> getTrafficByRoad(Long roadId) {
        List<TrafficFlow> trafficResponseList= trafficRepository.getTrafficRoad(roadId);
        return trafficMapper.trafficToTrafficResponseList(trafficResponseList);
    }
}
