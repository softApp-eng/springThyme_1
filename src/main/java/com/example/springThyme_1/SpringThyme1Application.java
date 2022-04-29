package com.example.springThyme_1;

import com.example.springThyme_1.dao.PatientRepository;
import com.example.springThyme_1.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringThyme1Application implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringThyme1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"youssef",new Date(),false));
		patientRepository.save(new Patient(null,"amine",new Date(),true));
		patientRepository.save(new Patient(null,"badr",new Date(),false));
		patientRepository.save(new Patient(null,"hamza",new Date(),true));
		patientRepository.save(new Patient(null,"ahmed",new Date(),false));


		 patientRepository.findAll().forEach(p->{
			 System.out.println(p.getName());
		 });
	}
}
