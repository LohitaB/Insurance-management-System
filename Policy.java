package com.insurance.claimprocessing.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String policyNumber;
private LocalDate startDate;
private LocalDate endDate;
private Double premium;
private String productType;
private String status; // ACTIVE, LAPSED, CANCELLED


@ManyToOne
private User user;
}