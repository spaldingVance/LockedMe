package com.hcl.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LockedMe implements Locker {
	
	static String basePath = "./src/resources";
	
	
	



	@Override
	public void addFile(String fileToAdd) {
		File file = new File("./src/resources/" + fileToAdd);

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error");
		}

	}
	
	public void addDirectory(String fileToAdd) {
		File file = new File("./src/resources/" + fileToAdd);

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	@Override
	public void deleteFile(String fileToDelete) {
		if (FileSearch.iterateThroughDirectory(fileToDelete, "./src/resources", false, true, true)) {
			System.out.println("File deleted");
		} else {
			System.out.println("File not found!");
		}
		
	}

	@Override
	public void searchForFile(String fileToSearchFor) {
		
		FileSearch.iterateThroughDirectory(fileToSearchFor, "./src/resources", false, true, false);

	}


	

	@Override
	public void listFiles() {

		FileSearch.iterateThroughDirectory("", basePath, true, false, false);

	}

}
