package com.insurance.claimprocessing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String performedBy;
    private String description;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    // Optional convenience constructor (for quick creation)
    public ClaimAudit(String action, String performedBy, String description, Claim claim) {
        this.action = action;
        this.performedBy = performedBy;
        this.description = description;
        this.claim = claim;
    }
}
