package com.ults.SecureOTP.controller;

import com.ults.SecureOTP.service.SecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OTPController {
    @Autowired
    SecureService secureService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateOTP(@RequestParam String userId) {
        try {
            String otp = secureService.generateOTP();
            secureService.saveOTP(userId, otp);
            return ResponseEntity.ok(otp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate OTP");
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOTP(@RequestParam String userId, @RequestParam String otp) {
        try {
            if (secureService.verifyOTP(userId, otp)) {
                return ResponseEntity.ok("OTP verified successfully. User authenticated.");
            } else {
                return ResponseEntity.ok("Invalid OTP or OTP expired. Authentication failed.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to verify OTP");
        }
    }

    @PostMapping("/authorize")
    public ResponseEntity<String> authorizeUser(@RequestParam String userId) {
        try {
            if (secureService.authorize(userId)) {
                return ResponseEntity.ok("Admin access!");
            } else {
                return ResponseEntity.ok("User access!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to authorize user");
        }
    }
}
