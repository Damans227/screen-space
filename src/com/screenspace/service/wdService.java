package com.screenspace.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screenspace.dao.imagesDao;


@WebServlet("/wdService")
public class wdService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List imageUrlList = imagesDao.imagesList();
		
		HttpSession session = request.getSession();
		request.setAttribute("imageUrlList", imageUrlList);

		
		RequestDispatcher rd = request.getRequestDispatcher("/welcomeDashboard.jsp");
		rd.forward(request, response);
	}

}
