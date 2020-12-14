package com.hcl.lockedMe;

public interface Locker {
	
	public void addFile(String fileToAdd);
	public void addDirectory(String directoryToAdd);
	public void deleteFile(String fileToDelete);
	public void searchForFile(String fileToSearchFor);
	public void listFiles();
	

}
