package TrafficFlow.traffic.repository;

import TrafficFlow.traffic.model.entity.TrafficFlow;
import TrafficFlow.traffic.type.FrameTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrafficRepository extends JpaRepository<TrafficFlow, Long> {
    @Query(value = "SELECT t FROM TrafficFlow t WHERE t.roadId = :roadId")
    List<TrafficFlow> getTrafficRoad(Long roadId);

    @Query(value = "SELECT t FROM TrafficFlow t WHERE t.roadId = :roadId AND t.date = :date AND t.frameTime = :frameTime")
    TrafficFlow checkTraffic(@Param("roadId") Long roadId, LocalDate date, FrameTime frameTime);

    @Query(value = "SELECT t FROM TrafficFlow t WHERE t.roadId = :roadId AND t.id = :trafficId")
    Optional<TrafficFlow> deleteTraffic(Long roadId, Long trafficId);


    @Query(value = "SELECT t FROM TrafficFlow t WHERE t.roadId = :roadId AND t.date = :date")
    List<TrafficFlow> getTrafficToRoadOneDay(Long roadId, LocalDate date);

}
