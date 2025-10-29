package com.insurance.claimprocessing.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String claimNumber;
    private LocalDate incidentDate;
    private OffsetDateTime reportedDate = OffsetDateTime.now();
    private BigDecimal amountClaimed;
    private BigDecimal amountApproved;
    private String status;
    private Double fraudScore = 0.0;
    @ManyToOne
    private Policy policy;
    @ManyToOne
    private User filedBy;
}
