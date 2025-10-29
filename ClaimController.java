package com.insurance.claimprocessing.controller;

import com.insurance.claimprocessing.entity.Claim;
import com.insurance.claimprocessing.repository.ClaimRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin("*")
public class ClaimController {

    private final ClaimRepository claimRepository;

    public ClaimController(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }
}
