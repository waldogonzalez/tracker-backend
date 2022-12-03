package com.inendev.tracker.mapper;

import com.inendev.tracker.domain.Device;
import com.inendev.tracker.dto.DeviceDTO;

public class DeviceMapper implements Mapper<Device, DeviceDTO> {

    private DeviceMapper() {
    }

    public static DeviceMapper get() {
        return new DeviceMapper();
    }

    @Override
    public DeviceDTO map(Device entity) {
        DeviceDTO deviceDto = new DeviceDTO();
        deviceDto.setId(entity.getId());
        deviceDto.setName(entity.getName());
        return deviceDto;
    }
}
