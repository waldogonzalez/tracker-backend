package com.inendev.tracker.mapper;

import com.inendev.tracker.domain.Tracking;
import com.inendev.tracker.dto.TrackingDto;
import org.springframework.stereotype.Service;

@Service
public class TrackingMapperFactory implements MapperFactory<Tracking, TrackingDto> {

    @Override
    public Mapper<Tracking, TrackingDto> getForSingle() {
        return TrackingMapper.get();
    }

    @Override
    public Mapper<Tracking, TrackingDto> getForMultiple() {
        return TrackingMapper.get();
    }
}
