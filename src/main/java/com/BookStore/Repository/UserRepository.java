package com.BookStore.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BookStore.Domain.User;

public interface UserRepository extends CrudRepository<User,Long> {

	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
	
}
