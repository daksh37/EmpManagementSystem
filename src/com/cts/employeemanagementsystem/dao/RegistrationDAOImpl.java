package com.cts.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagementsystem.util.DBUtils;

public class RegistrationDAOImpl implements RegistrationDAO {
	
	private static RegistrationDAOImpl registrationDAOImpl;
	public static  RegistrationDAOImpl getInstance() {
		if(registrationDAOImpl == null){
			registrationDAOImpl = new RegistrationDAOImpl();
			return registrationDAOImpl;
		}
		else 
			return registrationDAOImpl;
	}

	public String insertUser(Employee employee) {
		// TODO Auto-generated method stub\
		String query = "insert into employee values( ?, ?, ?, ? )" ;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getFname());
			preparedStatement.setString(3, employee.getLname());
			preparedStatement.setFloat(4, employee.getSalary());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return "record entered";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
