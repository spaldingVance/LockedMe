package com.hcl.lockedMe;

import java.util.Scanner;

public class TerminalDisplay {
	public void DisplayProgram() {
		
		char goAgain = 'y';
		
		
		System.out.println("Welcome to LockedMe! (Created by Spalding Vance)");
		
		
		do {
			System.out.println("Please enter a choice to get started! \n");
			System.out.println("1. Add a File");
			System.out.println("2. Delete a File");
			System.out.println("3. Search for a File");
			
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println("To add a file, please enter the name: ");
					String fileToAdd = sc.nextLine();
					
					break;
				case 2:
					System.out.println("To delete a file, please enter the name: ");
					String fileToDelete = sc.nextLine();
					
					break;
				case 3:
					System.out.println("To search for a file, please enter the name: ");
					String fileToSearch = sc.nextLine();
					break;
			}
			
			goAgain = sc.nextLine().toLowerCase().charAt(0);
			
			
			
			
		} while(goAgain == 'y');
		
	}
}
