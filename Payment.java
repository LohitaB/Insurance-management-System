package com.insurance.claimprocessing.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private String paymentMode;

    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    public Payment() {
    }

    public Payment(BigDecimal amount, LocalDateTime paymentDate, String paymentMode, String transactionId, Claim claim) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
        this.claim = claim;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
