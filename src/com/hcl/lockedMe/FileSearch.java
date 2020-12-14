package com.hcl.lockedMe;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

public class FileSearch {

	static TreeSet<String> fileNames = new TreeSet<String>();

	static TreeSet<String> fileAndDirectoryNames = new TreeSet<String>();

	static ArrayList<String> fileStructure = new ArrayList<String>();

	public static boolean iterateThroughDirectory(String fileToSearchFor, String path, boolean shouldSearch,
			boolean shouldDelete, boolean inFolder) {

		File f = new File(path);
		File directoryFiles[] = f.listFiles();

		for (File currentFile : directoryFiles) {

			if (currentFile.isFile()) {
				
				if (inFolder) {
					fileStructure.add(" --" + currentFile.getName());
				} else {
					fileStructure.add(currentFile.getName());
				}

				fileAndDirectoryNames.add(currentFile.getName());

				fileNames.add(currentFile.getName());

				if (shouldSearch && currentFile.getName().equals(fileToSearchFor)) {
					if (shouldDelete) {
						return currentFile.delete();

					} else {
						return true;
					}

				}

			} else if (currentFile.isDirectory()) {
				fileStructure.add(currentFile.getName() + "/");

				fileAndDirectoryNames.add(currentFile.getName());
				String pathName = currentFile.getAbsolutePath();
				iterateThroughDirectory(fileToSearchFor, pathName, shouldSearch, shouldDelete, true);

			}
		}

		return true;

	}

	public static void emptyFileStructure() {
		fileStructure.clear();
	}

	public static TreeSet<String> getFileAndDirectoryNames() {
		return fileAndDirectoryNames;
	}

	public static void setFileAndDirectoryNames(TreeSet<String> fileAndDirectoryNames) {
		FileSearch.fileAndDirectoryNames = fileAndDirectoryNames;
	}

	public static ArrayList<String> getFileStructure() {
		return fileStructure;
	}

	public static void setFileStructure(ArrayList<String> fileStructure) {
		FileSearch.fileStructure = fileStructure;
	}

	public static void setFileNames(TreeSet<String> fileNames) {
		FileSearch.fileNames = fileNames;
	}

	public static TreeSet<String> getFileNames() {
		return fileNames;
	}
}
