package com.inendev.tracker.repository;

import com.inendev.tracker.domain.BeaconRead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<BeaconRead, Long> {
}
