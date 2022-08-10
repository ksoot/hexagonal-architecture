package com.ak.architecture.hexagonal.ports;

import java.util.List;

import com.ak.architecture.hexagonal.core.UserDomain;

//The Ports acts as a gateway/entry or exit point which sits between external systems and our application.
//Through port application receive requests or send out responses or connect to other systems.
//An outbound port is something like a repository interface that facilitates communication from application to persistence system

// Application -> External systems (kafka, DB, Files)
public interface OutBoundPort {

	String getUser(String firstName, String lastName);
	List<UserDomain> getAllUsers();
	void createUser(String firstName, String lastName, String email);
	boolean updateUserEmail(String firstName, String lastName, String email);
	
}
