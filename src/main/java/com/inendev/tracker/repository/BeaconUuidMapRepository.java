package com.inendev.tracker.repository;

import com.inendev.tracker.domain.BeaconUuidMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeaconUuidMapRepository extends JpaRepository<BeaconUuidMap, Long> {
    Optional<BeaconUuidMap> findByUuid(String uuid);
}
