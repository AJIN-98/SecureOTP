package com.ults.SecureOTP.repository;

import com.ults.SecureOTP.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureOtpRepo extends JpaRepository<OTP, String> {

}
