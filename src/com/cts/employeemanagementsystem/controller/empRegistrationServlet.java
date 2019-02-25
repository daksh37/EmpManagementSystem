package com.cts.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagementsystem.service.RegistrationService;
import com.cts.employeemanagementsystem.service.RegistrationServiceImpl;

/**
 * Servlet implementation class empRegistrationServlet
 */
public class empRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId = request.getParameter("empId");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		float salary =Float.parseFloat(request.getParameter("salary"));
		Employee employee = new Employee(empId, fname, lname, salary);
		RequestDispatcher requestDispatcher = null;
		System.out.println(empId+" "+fname+" "+lname+" "+salary);
		RegistrationService registrationService = RegistrationServiceImpl.getInstance();
		registrationService.insertUser(employee);
		requestDispatcher = request.getRequestDispatcher("admin.html");
		requestDispatcher.forward(request, response);
	}

}
