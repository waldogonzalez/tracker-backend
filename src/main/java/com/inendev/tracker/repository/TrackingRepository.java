package com.inendev.tracker.repository;

import com.inendev.tracker.domain.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
}
