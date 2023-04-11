package com.example.accountingzoo;

import com.example.accountingzoo.model.dictionary.AnimalType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AccountingZooApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountingZooApplication.class, args);
    }

}
