package com.ults.SecureOTP.repository;

import com.ults.SecureOTP.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureUserRepo extends JpaRepository<Customer, String> {

}
