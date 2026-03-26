package TrafficFlow.traffic.mapper;

import TrafficFlow.traffic.model.dto.request.TrafficRequest;
import TrafficFlow.traffic.model.dto.response.TrafficResponse;
import TrafficFlow.traffic.model.entity.TrafficFlow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TrafficMapper {
    List<TrafficResponse> trafficToTrafficResponseList(List<TrafficFlow> trafficFlowList);



    @Mapping(target = "roadId", source = "roadId")
    TrafficFlow trafficRequestToTrafficCreate(TrafficRequest trafficRequest, Long roadId);


    TrafficResponse trafficToTrafficResponse(TrafficFlow trafficFlow);
    void updateTraffic(TrafficRequest trafficRequest, @MappingTarget TrafficFlow trafficFlow);
}
