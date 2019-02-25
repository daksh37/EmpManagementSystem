package com.cts.employeemanagementsystem.service;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagementsystem.dao.RegistrationDAO;
import com.cts.employeemanagementsystem.dao.RegistrationDAOImpl;

public class RegistrationServiceImpl implements RegistrationService {

	private static RegistrationServiceImpl registrationServiceImpl;
	private RegistrationDAO dao = RegistrationDAOImpl.getInstance();
	public static RegistrationService getInstance() {
	 if(registrationServiceImpl == null){
		 registrationServiceImpl = new RegistrationServiceImpl();
		 return registrationServiceImpl;
	 }
	 else
		 return registrationServiceImpl;
	
	}
	public String insertUser(Employee employee) {
		return dao.insertUser(employee);
	}
}
