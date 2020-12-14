package com.hcl.lockedMe;

import java.io.File;
import java.io.IOException;


public class LockedMe implements Locker {

	public String basePath = "./src/resources";

	public void addDirectory(String directoryToAdd) {
		String directoryPath = basePath + "/" + directoryToAdd;
		File file = new File(directoryPath);

		if (file.mkdir()) {
			System.out.println("Directory Created");
		} else {
			System.out.println("Unable to create directory!");
		}
	}


	public void addFile(String fileToAdd) {
		File file = new File("./src/resources/" + fileToAdd);

		try {
			
			if(file.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("Unable to create File");
			}
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
		if (fileExists) {
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
