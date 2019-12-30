package com.BookStore.Domain.Security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority, Serializable
{
	
	private static final long serialVersionUID=12222443456L;
	private  final String authority;
	public Authority(String authority)
	{
		this.authority=authority;
	}
	//Override the Interface method
	@Override
	public String getAuthority()
	{
		return authority;
	}
		
}
