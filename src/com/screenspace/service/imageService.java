package com.screenspace.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.screenspace.dao.imageDao;

@WebServlet("/imageService")

public class imageService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");

		InputStream inputStream = null;

		Part filePart = request.getPart("file");
		if (filePart != null && filePart.getSize() > 0) {

			long size = filePart.getSize();
			byte[] imageBytes = new byte[(int) size];

			// prints out some information for debugging
			/*
			 * System.out.println(filePart.getName());
			 * System.out.println(filePart.getSize());
			 * System.out.println(filePart.getContentType());
			 */

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();

			imageDao.uploadImage(imageBytes, uname, filePart.getSize(), filePart.getContentType(), filePart.getName());

			session.setAttribute("message", "Upload has been done successfully!");

			response.sendRedirect("wdController");
			return;

		} else {
			
			response.sendRedirect("wdController");
			return;
		}

	}

}
