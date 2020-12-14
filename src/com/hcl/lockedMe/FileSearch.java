package com.hcl.lockedMe;

import java.io.File;
import java.util.ArrayList;

public class FileSearch {
	
	static ArrayList<String> fileNames;
	
	
	
	public static void iterateThroughDirectory(String fileToSearchFor, String path, boolean shouldPrint,
			boolean shouldSearch, boolean shouldDelete) {

		File f = new File(path);
		File directoryFiles[] = f.listFiles();

		for (File currentFile : directoryFiles) {

			if (currentFile.isFile()) {
				if (shouldPrint) {
					System.out.println(currentFile.getName());
				}

				fileNames.add(currentFile.getName());

				if (shouldSearch && currentFile.getName().equals(fileToSearchFor)) {
					System.out.println("Match found!");
					return;
				}
			} else if (currentFile.isDirectory()) {
				if (shouldPrint) {
					System.out.println(currentFile + "/");
				}

				String pathName = currentFile.getAbsolutePath();
				iterateThroughDirectory(fileToSearchFor, pathName, shouldPrint, shouldSearch, shouldDelete);

			} else {
				if (shouldPrint) {
					System.out.println("unknown item");
				}

			}
		}

	}



	public static ArrayList<String> getFileNames() {
		return fileNames;
	}
}

