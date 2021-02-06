package com.example.shopping.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration @EnableJpaRepositories(basePackages="") @EnableTransactionManagement @EntityScan(basePackages="")
//@EntityScan({"com.example.shopping.online.model.Bill","com.example.shopping.model.Order","com.example.shopping.online.model.Product",})
public class ShoppingOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingOnlineApplication.class, args);
	}

}
