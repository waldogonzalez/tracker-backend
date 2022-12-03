package com.inendev.tracker.tracking;

import com.inendev.tracker.domain.Tracking;
import com.inendev.tracker.dto.TrackingDto;
import com.inendev.tracker.dto.TrackingPayload;
import com.inendev.tracker.mapper.Mapper;
import com.inendev.tracker.mapper.TrackingMapperFactory;
import com.inendev.tracker.repository.TrackingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackingService {
    private final TrackingRepository repository;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'");
    private final Mapper<Tracking, TrackingDto> multipleMapper;

    public TrackingService(TrackingRepository repository, TrackingMapperFactory mapperFactory) {
        this.repository = repository;
        this.multipleMapper = mapperFactory.getForMultiple();
    }

    @Transactional
    public void save(TrackingPayload trackingPayload) throws ParseException {
        Tracking tracking = new Tracking();
        TrackingPayload.DecodedPayload dp = trackingPayload.getUplinkMessage().getDecodedPayload();
        tracking.setAddr(dp.getAddr());
        tracking.setAlarm(dp.getAlarm());
        tracking.setBatV(BigDecimal.valueOf(dp.getBatV()));
        tracking.setBatV(BigDecimal.valueOf(dp.getBatV()));
        tracking.setMajor(dp.getMajor());
        tracking.setMinor(dp.getMinor());
        tracking.setRssi(dp.getRssi());
        tracking.setStepCount(dp.getStepCount());
        tracking.setUuid(dp.getUuid());
        tracking.setDeviceId(trackingPayload.getEndDeviceIds().getDeviceId());
        tracking.setTimestamp(dateFormat.parse(trackingPayload.getUplinkMessage().getReceivedAt()));

        this.repository.save(tracking);
    }

    public List<TrackingDto> getAll() {
        return repository.findAll().stream().map(multipleMapper::map).collect(Collectors.toList());
    }
}