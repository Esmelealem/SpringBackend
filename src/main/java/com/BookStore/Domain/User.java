package com.BookStore.Domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;

//import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.BookStore.Domain.Security.Authority;
import com.BookStore.Domain.Security.UserRole;
//import com.BookStore.Repository.UserRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails,Serializable {

	private static final long serialVersionUID=788889991L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="Id", nullable=false,updatable=false)
	private Long id;//Long and long are different here
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean enabled=true;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore// used for removing infinite loops in users
	private Set<UserRole>userRoles= new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUerRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority>authorities=new HashSet<>();
		userRoles.forEach(ur->authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
		//userRole as a set for each new user authority when we add user
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	//private ShoppingCart shopingCart;
}
