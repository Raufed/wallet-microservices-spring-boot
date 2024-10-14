package by.raufpayzov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class WalletUsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletUsersApplication.class,args);
    }
}