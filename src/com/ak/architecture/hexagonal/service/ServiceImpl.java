package com.ak.architecture.hexagonal.service;

import java.util.List;

import com.ak.architecture.hexagonal.adaptors.DrivenAdaptor;
import com.ak.architecture.hexagonal.core.UserDomain;
import com.ak.architecture.hexagonal.ports.OutBoundPort;

// adaptor uses the services to reach to domains
public class ServiceImpl implements Service{

	// get data from external system via port configured
	private OutBoundPort port = new DrivenAdaptor();
	
	@Override
	public String getUser(String firstName, String lastName) {
		return port.getUser(firstName, lastName);
	}

	@Override
	public List<UserDomain> getUsers() {
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
