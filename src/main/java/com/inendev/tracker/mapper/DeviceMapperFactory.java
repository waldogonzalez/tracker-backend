package com.inendev.tracker.mapper;

import com.inendev.tracker.domain.Device;
import com.inendev.tracker.dto.DeviceDTO;
import org.springframework.stereotype.Service;

@Service
public class DeviceMapperFactory implements MapperFactory<Device, DeviceDTO> {

    @Override
    public Mapper<Device, DeviceDTO> getForSingle() {
        return DeviceMapper.get();
    }

    @Override
    public Mapper<Device, DeviceDTO> getForMultiple() {
        return DeviceMapper.get();
    }
}
