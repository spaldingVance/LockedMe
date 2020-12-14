package com.hcl.lockedMe;

import com.hcl.lockedMe.exceptions.FileMismatchException;

public interface Locker {

	public void addFile(String fileToAdd);

	public void addDirectory(String directoryToAdd);

	public void deleteFile(String fileToDelete) throws FileMismatchException;

	public void searchForFile(String fileToSearchFor);

	public void listFiles();

}
