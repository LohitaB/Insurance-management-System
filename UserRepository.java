package com.insurance.claimprocessing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.claimprocessing.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByEmail(String email);
}