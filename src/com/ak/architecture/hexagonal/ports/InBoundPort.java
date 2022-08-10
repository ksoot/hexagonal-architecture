package com.ak.architecture.hexagonal.ports;

import java.util.List;

import com.ak.architecture.hexagonal.core.UserDomain;

// The Ports acts as a gateway/entry or exit point which sits between external systems and our application.
// Through port application receive requests or send out responses or connect to other systems.
// An Inbound port is something like a service interface that exposes the core logic to the outside world.

// External systems (kafka, Rest API, UX/UI) -> Application
public interface InBoundPort {

	String getUser(String name);
	List<UserDomain> getUsers();
	void createUser(String name, String email);
	boolean updateUserEmail(String name, String email);
	
}
