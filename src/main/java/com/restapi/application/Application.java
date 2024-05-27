package com.restapi.application;

import com.restapi.application.services.UserService;
import com.restapi.application.user.Role;
import com.restapi.application.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("hello");


	}

	@Bean
	public CommandLineRunner runner(UserService service){
		return args->{
			service.saveRole(new Role(null,"ROLE_USER"));
			service.saveRole(new Role(null,"ROLE_MANAGER"));
			service.saveRole(new Role(null,"ROLE_ADMIN"));
			service.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			service.saveUser(new User(null,"Virat Kohli","virat@gmail.com","12345",new ArrayList<>()));
			service.saveUser(new User(null,"Rohit Sharma","rohitsharma@gmail.com","12345",new ArrayList<>()));
			service.saveUser(new User(null,"MS Dhoni","msdhoni@gmail.com","12345",new ArrayList<>()));
			service.saveUser(new User(null,"Ruturaj Gaikwad","ruturaj@gmail.com","12345",new ArrayList<>()));

			service.addRolesToUser("virat@gmail.com","ROLE_USER");
			service.addRolesToUser("rohitsharma@gmail.com","ROLE_USER");
			service.addRolesToUser("msdhoni@gmail.com","ROLE_ADMIN");
			service.addRolesToUser("ruturaj@gmail.com","ROLE_SUPER_ADMIN");
			service.addRolesToUser("virat@gmail.com","ROLE_SUPER_ADMIN");

		};
	}

}
