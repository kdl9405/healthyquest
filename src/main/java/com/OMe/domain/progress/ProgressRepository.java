package com.OMe.domain.progress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserIdAndEquipmentId(Long uid, Long eid);
}
