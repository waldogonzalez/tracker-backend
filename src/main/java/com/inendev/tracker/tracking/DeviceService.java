package com.inendev.tracker.tracking;

import com.inendev.tracker.domain.Device;
import com.inendev.tracker.dto.DeviceDTO;
import com.inendev.tracker.mapper.DeviceMapperFactory;
import com.inendev.tracker.mapper.Mapper;
import com.inendev.tracker.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private final DeviceRepository repository;
    private final Mapper<Device, DeviceDTO> multiMapper;
    private final Mapper<Device, DeviceDTO> singleMapper;

    public DeviceService(DeviceRepository repository, DeviceMapperFactory mapperFactory) {
        this.repository = repository;
        this.multiMapper = mapperFactory.getForMultiple();
        this.singleMapper = mapperFactory.getForSingle();
    }

    public List<DeviceDTO> getAll() {
        return repository.findAll().stream().map(multiMapper::map).collect(Collectors.toList());
    }

    public DeviceDTO getById(Long id) {
        return repository.findById(id).map(singleMapper::map)
                .orElseThrow(() -> new IllegalArgumentException("Device # " + id + " doesn't exist"));
    }

    @Transactional
    public DeviceDTO saveIfNotRegistered(String name) {
        Optional<Device> byName = repository.findByName(name);
        if (byName.isEmpty()) {
            Device device = new Device();
            device.setName(name);
            repository.save(device);
            return singleMapper.map(device);
        } else {
            return singleMapper.map(byName.get());
        }
    }
}
