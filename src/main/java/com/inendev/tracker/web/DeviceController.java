package com.inendev.tracker.web;

import com.inendev.tracker.dto.DeviceDTO;
import com.inendev.tracker.tracking.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("device")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<DeviceDTO> list() {
        return deviceService.getAll();
    }
}
