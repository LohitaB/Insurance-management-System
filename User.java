package com.insurance.claimprocessing.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true, nullable = false)
private String email;
private String password;
private String fullName;
private String role; // ROLE_USER, ROLE_ASSESSOR, ROLE_ADMIN
private OffsetDateTime createdAt = OffsetDateTime.now();
}
