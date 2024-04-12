package com.ults.SecureOTP.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private boolean isAdmin;
}
