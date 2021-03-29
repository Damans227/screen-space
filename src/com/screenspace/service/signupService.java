package com.screenspace.service;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screenspace.dao.userDao;
import com.screenspace.model.userModel;

/**
 * Servlet implementation class signupService
 */
@WebServlet("/signupService")
public class signupService extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//System.out.println("signup service Fetched!");
	
		try {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		userDao uDao = new userDao();
		
		uDao.setUser(uname, pass, phone, email);
		
		HttpSession session = request.getSession();
		session.setAttribute("uname", uname);
		session.setAttribute("pass", pass);
		session.setAttribute("phone", phone);
		session.setAttribute("email", email);
		
		response.sendRedirect("wdController");
		
		}catch(Exception e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("loginService");
			rd.forward(request, response);
		}
		
	}

	}


