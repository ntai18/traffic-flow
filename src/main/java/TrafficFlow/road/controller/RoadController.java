package TrafficFlow.road.controller;


import TrafficFlow.exception.ApiResponse;
import TrafficFlow.road.model.dto.request.RoadRequest;
import TrafficFlow.road.model.dto.response.RoadResponse;
import TrafficFlow.road.service.RoadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/road")
@RequiredArgsConstructor
@Slf4j
public class RoadController {
    private final RoadService roadService;




    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<RoadResponse>>> getAll() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(roadService.getRoad());
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<RoadResponse>> createRoad(@RequestBody RoadRequest roadRequest) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(roadService.createRoad(roadRequest));
        return ResponseEntity.ok(apiResponse);
    }
    @PatchMapping("/update/{road-id}")
    public ResponseEntity<ApiResponse<RoadResponse>> updateRoad(@PathVariable("road-id") Long roadId, @RequestBody RoadRequest roadRequest) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(roadService.updateRoad(roadId, roadRequest));
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/delete/{road-id}")
    public ApiResponse deleteRoad(@PathVariable("road-id") Long roadId) {
        ApiResponse apiResponse = new ApiResponse();
        roadService.deleteRoad(roadId);
        apiResponse.setData("deleted!!    ID:  " + roadId);
        return apiResponse;
    }
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<RoadResponse>>> searchRoad(@RequestBody RoadRequest roadRequest) {
        log.info("Searching controller {}", roadRequest);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(roadService.searchRoad(roadRequest));
        return ResponseEntity.ok(apiResponse);
    }

}
