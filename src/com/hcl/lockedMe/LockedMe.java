package com.hcl.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LockedMe implements Locker {
	
	static String basePath = "./src/resources";
	
	static ArrayList<String> fileNames = new ArrayList<String>();
	
	



	@Override
	public void addFile(String fileToAdd) {
		File file = new File("./src/resources/" + fileToAdd);

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	@Override
	public void deleteFile(String fileToDelete) {
		File file = new File("./src/resources/" + fileToDelete);

		if (file.exists()) {
			boolean fileDeleted = file.delete();
			if (fileDeleted) {
				System.out.println("File deleted \n");
			}
		} else {
			System.out.println("The file was not found! \n");
		}
	}

	@Override
	public void searchForFile(String fileToSearchFor) {
		
		FileSearch.iterateThroughDirectory(fileToSearchFor, "./src/resources", false, true, false);

	}


	

	@Override
	public void listFiles() {

		FileSearch.iterateThroughDirectory("", basePath, false, false, false);
		System.out.println("\n All Files in Ascending Order: \n");
		for(String fileName : fileNames) {
			
			System.out.println(fileName);
		}
		
		System.out.println();

	}

}
