package com.insurance.claimprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.claimprocessing.entity.ClaimAudit;

public interface ClaimAuditRepository extends JpaRepository<ClaimAudit, Long> {
}
