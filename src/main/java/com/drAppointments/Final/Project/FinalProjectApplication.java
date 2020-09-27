package com.drAppointments.Final.Project;

import com.drAppointments.Final.Project.repository.AdminRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AdminRepository.class)
@EnableScheduling
public class FinalProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinalProjectApplication.class, args);
		System.out.println("Hello world!");
	}

}
