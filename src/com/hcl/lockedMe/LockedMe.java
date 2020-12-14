package com.hcl.lockedMe;

import java.io.File;
import java.io.IOException;

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

	@Override
	public void deleteFile(String fileToDelete) {
		File file = new File("./src/resources/" + fileToDelete);

		if (file.exists()) {
			boolean fileDeleted = file.delete();
			if (fileDeleted) {
				System.out.println("File deleted");
			}
		} else {
			System.out.println("The file was not found!");
		}
	}

	@Override
	public void searchForFile(String fileToSearchFor) {
		
		_iterateThroughDirectory(fileToSearchFor, "./src/resources", false, true);

	}

//	public static String getBasePath() {
//		return basePath;
//	}
//
//	public static void setBasePath(String basePath) {
//		LockedMe.basePath = basePath;
//	}

	private void _iterateThroughDirectory(String fileToSearchFor, String path, boolean shouldPrint, boolean shouldSearch) {
		
		File f = new File(path);
		File directoryFiles[] = f.listFiles();

		for (File currentFile : directoryFiles) {
			
			if (currentFile.isFile()) {
				if(shouldPrint) {
					System.out.println(currentFile.getName());
				}
				
				if (shouldSearch && currentFile.getName().equals(fileToSearchFor)) {
					System.out.println("Match found!");
					return;
				}
			} else if (currentFile.isDirectory()) {
				if(shouldPrint) {
					System.out.println(currentFile + "/");
				}
				
				String pathName = currentFile.getAbsolutePath();
				_iterateThroughDirectory(fileToSearchFor, pathName, shouldPrint, shouldSearch);
				

			} else {
				if(shouldPrint) {
					System.out.println("unknown item");
				}
				
			}
		}
	}

	@Override
	public void listFiles() {

		_iterateThroughDirectory("", basePath, true, false);

	}

}
