package com.insurance.claimprocessing.repository;

import com.insurance.claimprocessing.entity.ClaimDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimDocumentRepository extends JpaRepository<ClaimDocument, Long> {
}
