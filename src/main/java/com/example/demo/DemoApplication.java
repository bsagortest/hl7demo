package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*@Component
	public class DatabaseLoader implements CommandLineRunner{
		private final StudentRepository repo;
		
		@Autowired
		public DatabaseLoader(StudentRepository repo) {
			this.repo = repo;
		}

		@Override
		public void run(String... arg0) throws Exception {
			this.repo.save(new Student("Abu", "Bakar", "bsagor@gmail.com"));
		}
	}*/
}
