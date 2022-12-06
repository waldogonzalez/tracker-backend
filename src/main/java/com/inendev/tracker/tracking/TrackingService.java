package com.inendev.tracker.tracking;

import com.inendev.tracker.domain.BeaconRead;
import com.inendev.tracker.domain.BeaconUuidMap;
import com.inendev.tracker.dto.TrackingDto;
import com.inendev.tracker.dto.TrackingPayload;
import com.inendev.tracker.mapper.Mapper;
import com.inendev.tracker.mapper.TrackingMapperFactory;
import com.inendev.tracker.repository.BeaconUuidMapRepository;
import com.inendev.tracker.repository.TrackingRepository;
import org.springframework.data.domain.Sort;
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
    private final BeaconUuidMapRepository beaconUuidMapRepository;
    private final DeviceService deviceService;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Mapper<BeaconRead, TrackingDto> multipleMapper;

    public TrackingService(TrackingRepository repository, BeaconUuidMapRepository beaconUuidMapRepository, DeviceService deviceService,
                           TrackingMapperFactory mapperFactory) {
        this.repository = repository;
        this.beaconUuidMapRepository = beaconUuidMapRepository;
        this.deviceService = deviceService;
        this.multipleMapper = mapperFactory.getForMultiple();
    }

    @Transactional
    public void save(TrackingPayload trackingPayload) throws ParseException {
        BeaconRead beaconRead = new BeaconRead();
        TrackingPayload.DecodedPayload dp = trackingPayload.getUplinkMessage().getDecodedPayload();
        beaconRead.setAddr(dp.getAddr());
        beaconRead.setAlarm(dp.getAlarm());
        beaconRead.setBatV(BigDecimal.valueOf(dp.getBatV()));
        beaconRead.setBatV(BigDecimal.valueOf(dp.getBatV()));
        beaconRead.setMajor(dp.getMajor());
        beaconRead.setMinor(dp.getMinor());
        beaconRead.setRssi(dp.getRssi());
        beaconRead.setStepCount(dp.getStepCount());
        beaconRead.setUuid(dp.getUuid());
        beaconRead.setDeviceId(trackingPayload.getEndDeviceIds().getDeviceId());
        String receivedAt = trackingPayload.getUplinkMessage().getReceivedAt().replace("T", " ").replace("Z", "");
        beaconRead.setTimestamp(dateFormat.parse(receivedAt));

        beaconUuidMapRepository.findByUuid(beaconRead.getUuid())
                .map(BeaconUuidMap::getName)
                .ifPresent(beaconRead::setBeaconName);

        deviceService.saveIfNotRegistered(beaconRead.getDeviceId(), beaconRead.getBatV());

        this.repository.save(beaconRead);
    }

    public List<TrackingDto> getAll() {
        return repository.findAll(Sort.by(Sort.Order.desc("id"))).stream().map(multipleMapper::map).collect(Collectors.toList());
    }
}
