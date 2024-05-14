package com.capolavoroprova.capolavoro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.capolavoroprova.capolavoro.FirebaseInitializor.FirebaseInitiazization;


@SpringBootApplication
@CrossOrigin(origins = "*")
public class CapolavoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapolavoroApplication.class, args);
	}

	
}
