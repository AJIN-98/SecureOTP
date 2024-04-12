package com.ults.SecureOTP.mock;

import com.ults.SecureOTP.model.Customer;
import com.ults.SecureOTP.repository.SecureUserRepo;
import com.ults.SecureOTP.service.SecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockOTPDataInitializer implements CommandLineRunner {

    @Autowired
    SecureService secureService;

    @Autowired
    SecureUserRepo secureUserRepo;

    @Override
    public void run(String... args) throws Exception {
        //Data for OTP
        String userId1 = "user123";
        String otp1 = "123456";
        secureService.saveOTP(userId1, otp1);

        String userId2 = "user456";
        String otp2 = "654321";
        secureService.saveOTP(userId2, otp2);

        // Data for authorization
        Customer admin = new Customer();
        admin.setCustomerId("user789");
        admin.setCustomerName("abc");
        admin.setAdmin(true);
        secureUserRepo.save(admin);

        Customer user = new Customer();
        user.setCustomerId("user321");
        user.setCustomerName("def");
        user.setAdmin(false);
        secureUserRepo.save(user);


    }
}
