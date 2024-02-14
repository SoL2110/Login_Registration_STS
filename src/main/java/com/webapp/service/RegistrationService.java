package com.webapp.service;

import java.util.List;

import com.webapp.entity.Registration;

public interface RegistrationService {

	void createRegistration(Registration registration);
		// TODO Auto-generated method stub

	List<Registration> getRegistrations();
		
	void deleteRegistration(long id);

	Registration getRegistrationById(long id);

	void updateRegRecord(Registration registration);
}

