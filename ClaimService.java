package com.insurance.claimprocessing.service;

import com.insurance.claimprocessing.dto.CreateClaimDto;
import com.insurance.claimprocessing.entity.*;
import com.insurance.claimprocessing.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimRepository claimRepo;
    private final PolicyRepository policyRepo;
    private final UserRepository userRepo;
    private final ClaimAuditRepository auditRepo;

    @Transactional
    public Claim submitClaim(CreateClaimDto dto, Long userId) {
        Policy policy = policyRepo.findById(dto.getPolicyId())
                .orElseThrow(() -> new IllegalArgumentException("Policy not found"));
        User user = userRepo.findById(userId).orElseThrow();

        Claim claim = new Claim();
        claim.setClaimNumber("CLM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        claim.setPolicy(policy);
        claim.setFiledBy(user);
        claim.setIncidentDate(dto.getIncidentDate());
        claim.setAmountClaimed(dto.getAmountClaimed());
        claim.setStatus("SUBMITTED");

        Claim savedClaim = claimRepo.save(claim);
        auditRepo.save(new ClaimAudit("SUBMIT", user.getEmail(), "Submitted claim", savedClaim));
        return savedClaim;
    }

    public List<Claim> getAll() {
        return claimRepo.findAll();
    }

    @Transactional
    public Claim setFraudScore(Long claimId, double score, String actor) {
        Claim claim = claimRepo.findById(claimId).orElseThrow();
        claim.setFraudScore(score);
        claim.setStatus("IN_REVIEW");
        claimRepo.save(claim);
        auditRepo.save(new ClaimAudit("RUN_FRAUD", actor, "Fraud score: " + score, claim));
        return claim;
    }

    @Transactional
    public Claim assessClaim(Long claimId, boolean approve, String actor, BigDecimal amountApproved) {
        Claim claim = claimRepo.findById(claimId).orElseThrow();
        if (approve) {
            claim.setStatus("APPROVED");
            claim.setAmountApproved(amountApproved);
            auditRepo.save(new ClaimAudit("APPROVE", actor, "Approved amount: " + amountApproved, claim));
        } else {
            claim.setStatus("REJECTED");
            auditRepo.save(new ClaimAudit("REJECT", actor, "Rejected", claim));
        }
        return claimRepo.save(claim);
    }
}
