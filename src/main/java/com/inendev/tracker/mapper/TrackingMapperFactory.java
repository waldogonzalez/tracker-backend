package com.inendev.tracker.mapper;

import com.inendev.tracker.domain.BeaconRead;
import com.inendev.tracker.dto.TrackingDto;
import org.springframework.stereotype.Service;

@Service
public class TrackingMapperFactory implements MapperFactory<BeaconRead, TrackingDto> {

    @Override
    public Mapper<BeaconRead, TrackingDto> getForSingle() {
        return TrackingMapper.get();
    }

    @Override
    public Mapper<BeaconRead, TrackingDto> getForMultiple() {
        return TrackingMapper.get();
    }
}
