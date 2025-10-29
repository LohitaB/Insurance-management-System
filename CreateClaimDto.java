package com.insurance.claimprocessing.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateClaimDto {
    private Long policyId;
    private LocalDate incidentDate;
    private BigDecimal amountClaimed;
    private String notes;
}
