package com.devs.blogdevs;

import com.devs.blogdevs.dto.CommentRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogdevsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogdevsApplication.class, args);
	}
}
