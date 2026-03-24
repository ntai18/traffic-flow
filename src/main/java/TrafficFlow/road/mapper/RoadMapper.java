package TrafficFlow.road.mapper;

import TrafficFlow.road.model.dto.request.RoadRequest;
import TrafficFlow.road.model.dto.response.RoadResponse;
import TrafficFlow.road.model.entity.Road;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RoadMapper {
    List<RoadResponse> roadToRoadResponseList(List<Road> roads);
    Road roadRequestToRoad(RoadRequest roadRequest);
    RoadResponse road(Road road);
    void roadUpdate(RoadRequest roadRequest, @MappingTarget Road road);
}
