package com.inendev.tracker.web;

import com.inendev.tracker.dto.TrackingDto;
import com.inendev.tracker.tracking.TrackingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tracking")
public class TrackingController {
    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping
    public List<TrackingDto> list() {
        return trackingService.getAll();
    }
}
