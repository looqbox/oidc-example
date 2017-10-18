package com.looqbox.oidc.oidc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OidcApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{OidcApplication.class, OpenIdConnectConfig.class}, args);
	}

}
