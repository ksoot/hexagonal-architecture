package com.ak.architecture.hexagonal.adaptors;

import java.util.List;

import com.ak.architecture.hexagonal.core.UserDomain;
import com.ak.architecture.hexagonal.ports.InBoundPort;
import com.ak.architecture.hexagonal.service.Service;
import com.ak.architecture.hexagonal.service.ServiceImpl;

// The adapters act as an implementation of a port
// Port delegate request to adaptors, adaptors perform some responsibilities like,
// transformation of external request to application supportive nature. Conversion of external models to application models
// Known as Primary/Driving adapters 
// Ex. Examples of primary adapters could be WebViews or Rest Controllers.

// External systems (kafka, Rest API, UX/UI) -> InBound Ports ->  Primary/Driving adaptor -> Application


public class DrivingAdaptor implements InBoundPort{

	private Service service = new ServiceImpl();
	
	@Override
	public String getUser(String name) {
		// transformation of external request to application supportive nature. Conversion of external models to application models
		String[] arr = name.split(" ");
		String firstName = arr[0];
		String lastName = arr[1];
		// reach to domain via service
		service.getUser(firstName, lastName);
		return null;
	}

	@Override
	public List<UserDomain> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(String name, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateUserEmail(String name, String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
