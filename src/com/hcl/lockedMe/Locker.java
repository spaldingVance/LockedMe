package com.hcl.lockedMe;

public interface Locker {
	
	public void addFile(String fileToAdd);
	public void deleteFile(String fileToDelete);
	public void searchFile(String fileToSearch);
	public void listFiles();
	

}
