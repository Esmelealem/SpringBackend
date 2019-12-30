package com.BookStore.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BookStore.Domain.User;
import com.BookStore.Repository.UserRepository;

@Service
public class UserSecuirtyService implements UserDetailsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecuirtyService.class); 	
	
	@Autowired
private UserRepository userRepository;// used to access the database 

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
{
	User user=userRepository.findByUsername(username);
	if(null==user)
{
	LOG.warn("UserName {} NotFound",username);
	throw new UsernameNotFoundException("User Name"+username+"Not Found");
	}
	return user;
 }
}
