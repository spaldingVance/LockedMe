package com.hcl.lockedMe;

import java.io.File;

import com.hcl.lockedMe.exceptions.FileMismatchException;

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
		System.out.println("\n");
	}

	public void addFile(String fileToAdd) {
		File file = new File("./src/resources/" + fileToAdd);

		try {

			if (file.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("Unable to create File");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("\n");

	}

	@Override
	public void deleteFile(String fileToDelete) throws FileMismatchException {
		if (FileSearch.iterateThroughDirectory(fileToDelete, "./src/resources", true, true, false)) {
			System.out.println("File deleted");
		} else {
			throw new FileMismatchException("Uh oh! File not found!");
		}
		System.out.println("\n");

	}

	@Override
	public void searchForFile(String fileToSearchFor) {

		boolean fileExists = FileSearch.iterateThroughDirectory(fileToSearchFor, "./src/resources", true, false, false);
		if (fileExists) {
			System.out.println("File found!");
		} else {
			System.out.println("File not found!");
		}
		System.out.println("\n");
	}

	@Override
	public void listFiles() {

		FileSearch.iterateThroughDirectory("", basePath, false, false, false);

		for (String fileName : FileSearch.getFileNames()) {
			System.out.println(fileName);
		}
		System.out.println("\n");

	}

	public void listFilesAndDirectories() {
		FileSearch.iterateThroughDirectory("", basePath, false, false, false);
		
		
		for (String fileName : FileSearch.getFileAndDirectoryNames()) {
			System.out.println(fileName);
		}
		System.out.println("\n");
		
	}
	
	public void listFileStructure() {
		FileSearch.iterateThroughDirectory("", basePath, false, false, false);
		
		for (String fileName : FileSearch.getFileStructure()) {
			System.out.println(fileName);
		}
		
		System.out.println("\n");
	}

}
