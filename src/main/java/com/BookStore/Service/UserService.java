package com.BookStore.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.BookStore.Domain.User;
import com.BookStore.Domain.Security.UserRole;

@Service
public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);

}
