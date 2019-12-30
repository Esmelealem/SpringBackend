package com.BookStore;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.BookStore.Config.SecurityUtility;
import com.BookStore.Domain.User;
import com.BookStore.Domain.Security.Role;
import com.BookStore.Domain.Security.UserRole;
import com.BookStore.Service.UserService;

//import com.BookStore.Repository.UserRepository;
	//@SpringBootApplication
	//@SpringBootApplication(scanBasePackages={"com.BookStore"})
@SpringBootApplication

public class SaBookStoreApplication implements CommandLineRunner {
	
		@Autowired
		private UserService userService;

		public static void main(String[] args) {
			SpringApplication.run(SaBookStoreApplication.class, args);
		}
		
		@Override
		public void run(String... args) throws Exception {
			User user1 = new User();
			user1.setId(200l);
			user1.setFirstName("EM");
			user1.setLastName("M");
			user1.setUsername("e");
			user1.setPassword(SecurityUtility.passwordEncoder().encode("e"));
			user1.setEmail("eme2119@gmail.com");
			Set<UserRole> userRoles = new HashSet<>();
			Role role1 = new Role();
			role1.setRoleId(1);
			role1.setName("ROLE_USER");
			userRoles.add(new UserRole(user1, role1));
			
			userService.createUser(user1, userRoles);
			
			userRoles.clear();
			
			User user2 = new User();
			user2.setId(2200l);
			user2.setFirstName("Admin");
			user2.setLastName("Admin");
			user2.setUsername("admin");
			user2.setPassword(SecurityUtility.passwordEncoder().encode("e"));
			user2.setEmail("eme2119@gmail.com");
			Role role2 = new Role();
			role2.setRoleId(0);
			role2.setName("ROLE_ADMIN");
			userRoles.add(new UserRole(user2, role2));
			
			userService.createUser(user2, userRoles);
		}
		
	}
