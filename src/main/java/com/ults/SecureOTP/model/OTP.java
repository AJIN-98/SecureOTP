package com.ults.SecureOTP.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Data
public class OTP {

    @Id
    String userId;
    private String otp;
    private LocalDateTime createdAt;
}
