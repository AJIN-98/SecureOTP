package com.ults.SecureOTP.service;

import org.springframework.stereotype.Service;

@Service
public interface SecureService {
    String generateOTP();
    void saveOTP(String userId, String otp);
    boolean verifyOTP(String userId, String otp);
    boolean authorize(String customerId);

}
