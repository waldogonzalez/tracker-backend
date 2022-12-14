package com.inendev.tracker.mapper;

import com.inendev.tracker.domain.BeaconRead;
import com.inendev.tracker.dto.TrackingDto;

public class TrackingMapper implements Mapper<BeaconRead, TrackingDto> {

    private TrackingMapper() {
    }

    public static TrackingMapper get() {
        return new TrackingMapper();
    }

    @Override
    public TrackingDto map(BeaconRead entity) {
        TrackingDto trackingDto = new TrackingDto();
        trackingDto.setId(entity.getId());
        trackingDto.setAddr(entity.getAddr());
        trackingDto.setAlarm(entity.getAlarm());
        trackingDto.setBatV(entity.getBatV());
        trackingDto.setMajor(entity.getMajor());
        trackingDto.setMinor(entity.getMinor());
        trackingDto.setRssi(entity.getRssi());
        trackingDto.setStepCount(entity.getStepCount());
        trackingDto.setUuid(entity.getUuid());
        trackingDto.setDeviceId(entity.getDeviceId());
        trackingDto.setTimestamp(entity.getTimestamp());
        trackingDto.setBeaconName(entity.getBeaconName());
        return trackingDto;
    }
}
