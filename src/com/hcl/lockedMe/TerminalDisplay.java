package com.hcl.lockedMe;

import java.util.Scanner;

public class TerminalDisplay {

	public static void main(String[] args) {
		displayProgram();
	}

	public static void displayProgram() {

		char goAgain = 'y';

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

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("To add a file, please enter the name: ");
				String fileToAdd = sc.nextLine();
				locker.addFile(fileToAdd);

				break;
			case 2:
				System.out.println("To add a directory, please enter the name: ");
				String directoryToAdd = sc.nextLine();
				locker.addDirectory(directoryToAdd);
			case 3:
				System.out.println("To delete a file, please enter the name: ");
				String fileToDelete = sc.nextLine();

				locker.deleteFile(fileToDelete);

				break;
			case 4:
				System.out.println("To search for a file, please enter the name: ");
				String fileToSearchFor = sc.nextLine();
				locker.searchForFile(fileToSearchFor);
				break;
			case 5:
				locker.listFiles();
				break;
			default:
				System.out.println("Option not found, please try again!");

			}

			System.out.println("Would you like to perform another operation? (y/n)");

			goAgain = sc.nextLine().toLowerCase().charAt(0);

		} while (goAgain == 'y');

		sc.close();

		System.out.println("\n goodbye!");

	}

}
