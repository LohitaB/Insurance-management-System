package com.insurance.claimprocessing.repository;

import com.insurance.claimprocessing.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
