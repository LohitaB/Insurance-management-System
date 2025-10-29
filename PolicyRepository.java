package com.insurance.claimprocessing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.claimprocessing.entity.Policy;


public interface PolicyRepository extends JpaRepository<Policy, Long> {
}