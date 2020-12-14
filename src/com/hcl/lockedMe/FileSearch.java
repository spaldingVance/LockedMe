package com.hcl.lockedMe;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

public class FileSearch {

	static TreeSet<String> fileNames = new TreeSet<String>();

	public static boolean iterateThroughDirectory(String fileToSearchFor, String path, boolean shouldSearch,
			boolean shouldDelete) {

		File f = new File(path);
		File directoryFiles[] = f.listFiles();

		for (File currentFile : directoryFiles) {

			if (currentFile.isFile()) {

				fileNames.add(currentFile.getName());

				if (shouldSearch && currentFile.getName().equals(fileToSearchFor)) {
					if (shouldDelete) {
						return currentFile.delete();

					} else {
						return true;
					}

				}

			} else if (currentFile.isDirectory()) {

				String pathName = currentFile.getAbsolutePath();
				iterateThroughDirectory(fileToSearchFor, pathName, shouldSearch, shouldDelete);

			}
		}
		return true;

	}

	public static TreeSet<String> getFileNames() {
		return fileNames;
	}
}
