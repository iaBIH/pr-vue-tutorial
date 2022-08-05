package net.javaguides.sbBE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sbBE.entity.Emp;
import net.javaguides.sbBE.repo.EmpRepo;

@SpringBootApplication
public class SbBeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbBeApplication.class, args);
	}

	@Autowired
	private EmpRepo empRepo;

	@Override
	public void run(String... args) throws Exception {
           
		Emp emp1 = Emp.builder()
					.id(11)
					.name("aaaaa")
					.age(10)	
					.build();										
		Emp emp2 = Emp.builder()
					.id(22)
					.name("bbbbb")
					.age(20)	
					.build();									
		Emp emp3 = Emp.builder()
					.id(33)
					.name("cccc")
					.age(30)	
					.build();		
		empRepo.save(emp1);													
		empRepo.save(emp2);													
		empRepo.save(emp3);													
	}
	

}
