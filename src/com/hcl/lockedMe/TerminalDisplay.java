package com.hcl.lockedMe;

import java.util.Scanner;

import com.hcl.lockedMe.exceptions.FileMismatchException;

public class TerminalDisplay {

	public static void main(String[] args) {
		displayProgram();
	}

	public static void displayProgram() {

		boolean goAgain = true;

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to LockedMe! (Created by Spalding Vance)");

		LockedMe locker = new LockedMe();

		do {
			System.out.println("Please enter a choice to get started! \n");
			System.out.println("1. Add a File");
			System.out.println("2. Add a Directory");
			System.out.println("3. Delete a File");
			System.out.println("4. Search for a File");
			System.out.println("5. List all Files");
			System.out.println("6. List all Directories and Files");
			System.out.println("7. List File and Directory Structure");
			System.out.println("8. Exit the Program \n");
		

			int choice = sc.nextInt();
			sc.nextLine();

			char firstLetter = 'n';

			switch (choice) {

			case 1:
				while (firstLetter != '!') {
					System.out.println("To add a file, please enter the name, or enter '!' to exit: ");
					String fileToAdd = sc.nextLine();
					firstLetter = fileToAdd.charAt(0);
					if (firstLetter == '!') {
						break;
					}
					locker.addFile(fileToAdd);
					
				}
				break;
		
			case 2:
				while (firstLetter != '!') {
					System.out.println("To add a directory, please enter the name, or enter '!' to exit: ");
					String directoryToAdd = sc.nextLine();
					firstLetter = directoryToAdd.charAt(0);
					if (firstLetter == '!') {
						break;
					}
					locker.addDirectory(directoryToAdd);
				}
				
			case 3:
				while (firstLetter != '!') {
					System.out.println("To delete a file, please enter the name, or enter '!' to exit: ");
					String fileToDelete = sc.nextLine();
					firstLetter = fileToDelete.charAt(0);
					if (firstLetter == '!') {
						break;
					}
					try {
						locker.deleteFile(fileToDelete);
					} catch (FileMismatchException e) {
						e.printStackTrace();
					}
				}
				break;
				
			case 4:
				while (firstLetter != '!') {
					System.out.println("To search for a file, please enter the name, or enter '!' to exit: ");
					String fileToSearchFor = sc.nextLine();
					firstLetter = fileToSearchFor.charAt(0);
					if (firstLetter == '!') {
						break;
					}
					locker.searchForFile(fileToSearchFor);
				}
				break;
			case 5:
				locker.listFiles();
				break;
			case 6:
				locker.listFilesAndDirectories();
				break;
			case 7:
				locker.listFileStructure();
				break;
			case 8:
				goAgain = false;
				break;
				
			default:
				System.out.println("Option not found, please try again!");
			}

		} while (goAgain);

		sc.close();

		System.out.println("\n goodbye!");

	}

}
