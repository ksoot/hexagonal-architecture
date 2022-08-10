package com.ak.architecture.hexagonal.adaptors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ak.architecture.hexagonal.core.UserDomain;
import com.ak.architecture.hexagonal.ports.OutBoundPort;

//The adapters act as an implementation of a port
//Port delegate request to adaptors, adaptors perform some responsibilities like,
//transformation of external request to application supportive nature. Conversion of external models to application models
//Known as Secondary/Driven adapters 
//Ex. Examples of Secondary adapters could be Connection with messaging queues, databases, and external API, files etc.

// Application -> Secondary/Driven adaptor -> OutBound Ports -> External systems (kafka, Rest API, UX/UI) 

public class DrivenAdaptor implements OutBoundPort{

	// here we are getting or saving or updating details in local cache. This could be either JMS template, JPA etc,
	//Just provide new implementation for this port for different source
	 
	private Map<String, UserDomain> userDomainStore  = new HashMap<String, UserDomain>();
	
	@Override
	public String getUser(String firstName, String lastName) {
		return userDomainStore.get(firstName+lastName).getFirstName();
	}

	@Override
	public List<UserDomain> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateUserEmail(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
