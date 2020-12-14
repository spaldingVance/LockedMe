package com.hcl.lockedMe;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

public class FileSearch {

	static TreeSet<String> fileNames = new TreeSet<String>();

	public static boolean iterateThroughDirectory(String fileToSearchFor, String path, boolean shouldPrint,
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
					if (shouldDelete) {
						return currentFile.delete();

					} else {
						return true;
					}

				}

			} else if (currentFile.isDirectory()) {
				if (shouldPrint) {
					System.out.println(currentFile + "/");
				}

				String pathName = currentFile.getAbsolutePath();
				iterateThroughDirectory(fileToSearchFor, pathName, shouldPrint, shouldSearch, shouldDelete);

			}
		}
		return true;

	}

	public static TreeSet<String> getFileNames() {
		return fileNames;
	}
}
