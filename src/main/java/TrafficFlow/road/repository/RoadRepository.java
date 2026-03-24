package TrafficFlow.road.repository;

import TrafficFlow.road.model.dto.request.RoadRequest;
import TrafficFlow.road.model.dto.response.RoadResponse;
import TrafficFlow.road.model.entity.Road;
import TrafficFlow.road.type.RoadType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<Road, Long> {
    @Query(value = " SELECT r FROM Road r ")
    List<Road> getRoads();

    @Query(value = "SELECT r FROM Road r WHERE r.id = :roadId")
    Optional<Road> getRoadId(@Param("roadId") Long roadId);

    @Query(value = "SELECT r FROM Road r WHERE r.roadType = :roadType")
    List<Road> searchRoad(RoadType roadType);


}
