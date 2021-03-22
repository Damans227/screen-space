package com.screenspace.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



@WebServlet("/uploadService")
public class uploadService extends HttpServlet {

	/*
	 * Name of the directory where uploaded files will be saved, relative to the web
	 * application directory.
	 */
	private static final String SAVE_DIR = "/Users/darora/eclipse-workspace/Screenspace/WebContent/images";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try {

			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);

			for (FileItem item : multifiles) {

				item.write(new File((SAVE_DIR + File.separator) + item.getName()));

			}
			
			HttpSession session = request.getSession();
			session.setAttribute("message", "Upload has been done successfully!");

			response.sendRedirect("wdController");
			return;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Reference Section:
		 * https://stackoverflow.com/questions/2308188/getresourceasstream-vs-
		 * fileinputstream
		 */

	}
		
	}


