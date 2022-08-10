package com.ak.architecture.hexagonal.service;

import java.util.List;

import com.ak.architecture.hexagonal.core.UserDomain;

// adaptor uses the services to reach to domains
public interface Service {

	String getUser(String firstName, String lastName);
	List<UserDomain> getUsers();
	void createUser(String firstName, String lastName, String email);
	boolean updateUserEmail(String firstName, String lastName, String email);
	
}
