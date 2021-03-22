package com.screenspace.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class imagesDao {
	
	private static final String SAVE_DIR = "/Users/darora/eclipse-workspace/Screenspace/WebContent/images/";
	
	public static List imagesList() {
		
		
		List imageUrlList = new ArrayList();  
		File imageDir = new File(SAVE_DIR);  
		for(File imageFile : imageDir.listFiles()){  
		  String imageFileName = imageFile.getName();  

		  // add this images name to the list we are building up  
		  imageUrlList.add(imageFileName);  

		}  

		
		
		return imageUrlList;
		
		
	}

}
