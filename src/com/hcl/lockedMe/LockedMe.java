package com.hcl.lockedMe;

import java.io.File;
import java.io.IOException;

public class LockedMe implements Locker {

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
		
		if(file.exists()) {
			boolean fileDeleted = file.delete();
			if(fileDeleted) {
				System.out.println("File deleted");
			} 
		} else {
			System.out.println("The file was not found!");
		}
	}

	@Override
	public void searchFile(String fileToSearch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listFiles() {
		// TODO Auto-generated method stub
		
		File file = new File("./src/resources");
		
		String[] fileNames = file.list();
		
		
		
		for (String fileName : fileNames) {
			System.out.println(fileName);
			
		}
		
		
		
	}

	
	
}
