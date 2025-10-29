package com.insurance.claimprocessing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
        <h2>✅ Insurance Claim Processing System is Running!</h2>
        <p>Available endpoints:</p>
        <ul>
          <li><a href='/h2-console'>H2 Console</a></li>
          <li>POST /api/users/register - Register new user</li>
          <li>POST /api/claims - Submit a claim</li>
          <li>GET /api/claims - View all claims</li>
        </ul>
        """;
    }
}
