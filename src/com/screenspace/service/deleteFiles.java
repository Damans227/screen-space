package com.screenspace.service;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import com.screenspace.dao.imageDao;
import com.screenspace.dao.imagesDao;


@WebServlet("/deleteFiles")
public class deleteFiles extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			String uname = (String) session.getAttribute("uname");
		
			imageDao.deleteImages(uname);
			response.sendRedirect("wdController");
		
	}

}
