package com.insurance.claimprocessing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.claimprocessing.entity.Claim;


public interface ClaimRepository extends JpaRepository<Claim, Long> {
}