package com.devs.blogdevs;

import com.devs.blogdevs.dto.CommentRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogdevsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogdevsApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "admin123";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println("Senha original: " + rawPassword);
		System.out.println("Senha hash (para o SQL): " + encodedPassword);
		CommentRequest request = new CommentRequest();
		System.out.println("Conteúdo recebido: " + request.getContent());

	}
}
