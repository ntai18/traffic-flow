package TrafficFlow.traffic.controller;

import TrafficFlow.exception.ApiResponse;
import TrafficFlow.traffic.model.dto.request.TrafficRequest;
import TrafficFlow.traffic.model.dto.response.TrafficResponse;
import TrafficFlow.traffic.service.TrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traffic")
@RequiredArgsConstructor
public class TrafficController {
    private final TrafficService trafficService;



    @GetMapping("/{road_id}")
    public ResponseEntity<ApiResponse<List<TrafficResponse>>> getTraffic(@PathVariable("road_id") Long road_id) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(trafficService.getTraffic(road_id));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PatchMapping("/update/{road_id}/{traffic_id}")
    public ResponseEntity<ApiResponse<TrafficResponse>> updateTraffic(@PathVariable("road_id") Long roadId, @PathVariable("traffic_id") Long trafficId, @RequestBody TrafficRequest trafficRequest) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(trafficService.updateTraffic(roadId, trafficId, trafficRequest));
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping("/create/{road_id}")
    public ResponseEntity<ApiResponse<List<TrafficResponse>>> createTraffic(@PathVariable("road_id") Long roadId, @RequestBody TrafficRequest trafficRequest) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(trafficService.createTraffic(roadId, trafficRequest));
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/delete/{road_id}/{traffic_id}")
    public ResponseEntity<ApiResponse> deleteTraffic(@PathVariable("road_id") Long roadId,@PathVariable("traffic_id") Long trafficId ) {
        trafficService.deleteTraffic(roadId, trafficId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Success delete:    ID: "+roadId+"  Traffic ID: "+trafficId);

        return ResponseEntity.ok(apiResponse);
    }

}
