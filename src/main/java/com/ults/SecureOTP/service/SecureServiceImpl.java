package com.ults.SecureOTP.service;

import com.ults.SecureOTP.model.Customer;
import com.ults.SecureOTP.model.OTP;
import com.ults.SecureOTP.repository.SecureOtpRepo;
import com.ults.SecureOTP.repository.SecureUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class SecureServiceImpl implements SecureService {
    private static final String ALLOWED_CHARACTERS = "0123456789";

    @Autowired
    SecureOtpRepo otpRepository;

    @Autowired
    SecureUserRepo userRepository;

    @Override
    public String generateOTP() {
        int length = 6;
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }
        return otp.toString();
    }

    @Override
    public void saveOTP(String userId, String otp) {
        OTP otpEntity = new OTP();
        otpEntity.setUserId(userId);
        otpEntity.setOtp(otp);
        otpEntity.setCreatedAt(LocalDateTime.now());
        otpRepository.save(otpEntity);
    }

    @Override
    public boolean verifyOTP(String userId, String otp) {
        OTP otpEntity = otpRepository.findById(userId).orElse(null);
        if (otpEntity != null && otpEntity.getOtp().equals(otp)) {
            LocalDateTime createdAt = otpEntity.getCreatedAt();
            return createdAt.isAfter(LocalDateTime.now().minusMinutes(5)); // 5 minutes for an OTP
        }
        return false;
    }

    @Override
    public boolean authorize(String customerId) {
        Customer customer = userRepository.findById(customerId).orElse(null);
        return customer.isAdmin();
    }
}
