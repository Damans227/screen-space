package com.screenspace.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screenspace.dao.imageDao;
import com.screenspace.dao.imagesDao;
import com.screenspace.model.imageModel;


@WebServlet("/previewController")
public class previewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		
		List<imageModel> imageUrlList = imageDao.listImages(uname);
		

		request.setAttribute("imageUrlList", imageUrlList);

		RequestDispatcher rd = request.getRequestDispatcher("/preview.jsp");
		rd.forward(request, response);
		
		
	}

}
