package com.hcl.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LockedMe implements Locker {
	
	public String basePath = "./src/resources";
	
	
	



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
			System.out.println("Error " + e);
		}

	}

	@Override
	public void deleteFile(String fileToDelete) {
		if (FileSearch.iterateThroughDirectory(fileToDelete, "./src/resources", true, true)) {
			System.out.println("File deleted");
		} else {
			System.out.println("File not found!");
		}
		
	}

	@Override
	public void searchForFile(String fileToSearchFor) {
		
		boolean fileExists = FileSearch.iterateThroughDirectory(fileToSearchFor, "./src/resources", true, false);
		if(fileExists) {
			System.out.println("File found!");
		} else {
			System.out.println("File not found!");
		}
	}


	

	@Override
	public void listFiles() {

		FileSearch.iterateThroughDirectory("", basePath, false, false);
		
		for (String fileName : FileSearch.getFileNames()) {
			System.out.println(fileName);
		}

	}

}
