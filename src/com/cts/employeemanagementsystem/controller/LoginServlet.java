package com.cts.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagementsystem.service.LoginService;
import com.cts.employeemanagementsystem.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		//doGet(request, response);
		LoginService loginService = LoginServiceImpl.getInstance();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		//System.out.println(userId+" "+password);
		RequestDispatcher requestDispatcher = null;
		if(loginService.authenticate(userId, password)){
			//response.sendRedirect("admin.html");
			int userstatus = loginService.getUserStatus(userId);
			String authorization = loginService.authorization(userId);
			if("A".equals(authorization)){
				if ( userstatus == 0){
					requestDispatcher = request.getRequestDispatcher("admin.html");
					requestDispatcher.forward(request, response);
				}
				else if( userstatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.html");
					requestDispatcher.forward(request, response);
				}
				else if ( userstatus == 2){
					requestDispatcher = request.getRequestDispatcher("deact.html");
					requestDispatcher.forward(request, response);
				}
			}
			
			else if("V".equals(authorization)){
				if ( userstatus == 0){
					requestDispatcher = request.getRequestDispatcher("venderhome.html");
					requestDispatcher.forward(request, response);
				}
				else if( userstatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.html");
					requestDispatcher.forward(request, response);
				}
				else if ( userstatus == 2){
					requestDispatcher = request.getRequestDispatcher("deact.html");
					requestDispatcher.forward(request, response);
				}
			}
			
			else if("U".equals(authorization)){
				if ( userstatus == 0){
					requestDispatcher = request.getRequestDispatcher("normal.html");
					requestDispatcher.forward(request, response);
				}
				else if( userstatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.html");
					requestDispatcher.forward(request, response);
				}
				else if ( userstatus == 2){
					requestDispatcher = request.getRequestDispatcher("deact.html");
					requestDispatcher.forward(request, response);
				}
			}
			
			
			//requestDispatcher.include(request, response);
		}
		else{
			requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.forward(request, response);
		}
	}
}
