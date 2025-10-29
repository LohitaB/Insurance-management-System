package com.insurance.claimprocessing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "claim_document")
public class ClaimDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;
    private String documentType;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    public ClaimDocument() {}

    public ClaimDocument(String documentName, String documentType, byte[] data, Claim claim) {
        this.documentName = documentName;
        this.documentType = documentType;
        this.data = data;
        this.claim = claim;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
