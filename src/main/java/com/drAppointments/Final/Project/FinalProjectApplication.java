package com.drAppointments.Final.Project;

import com.drAppointments.Final.Project.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FinalProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinalProjectApplication.class, args);
		System.out.println("Hello world!");
	}

}
