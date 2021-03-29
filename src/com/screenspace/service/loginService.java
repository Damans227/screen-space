package com.screenspace.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screenspace.dao.userDao;
import com.screenspace.model.userModel;

/**
 * Servlet implementation class loginService
 */
@WebServlet("/loginService")
public class loginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		userDao uDao = new userDao();
		userModel user = uDao.getUser(uname, pass);
		
		if(user!=null) {
		
		if(user.getUname().equals(uname) && user.getPass().equals(pass)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("pass", user.getPass());
			session.setAttribute("phone", user.getPhone());
			session.setAttribute("email", user.getEmail());
			
			response.sendRedirect("wdController");
			
		} else {
			
			response.sendRedirect("login.jsp");
			
		}
		
		}
		else {

			response.sendRedirect("/Screenspace");
		}
		

		
	}

}
