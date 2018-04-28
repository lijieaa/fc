package com.we.fc;

import com.we.fc.config.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
 public class FcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FcApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FcApplication.class);
	}

	@Bean
	public SpringUtils springUtils(){
		return new SpringUtils();
	}
}
