package main_page;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.*;


public class LockedMe {
	public static Scanner sc=new Scanner(System.in);
	public static ArrayList<String> files =new ArrayList<String>();
	
	public static void deleteFromDir(String name) {      //delete a file
		if (files.contains(name)){
			files.remove(name);
			System.out.println("Removed : " +name+"\n");
		}
		else {
			System.out.println("File " + name + " not present"+"\n");
		}
	}
	

	public static void displayDir() {                    // display the list of files present
		Collections.sort(files);    //displaying files in sorted order
		System.out.println(files +"\n");
	}
	

	public static void addInDir(String name) {           // add a file 
		files.add(name);
		System.out.println(name + "  Added in file"+"\n");
	}
	
	
	public static void searchFile(String name) {            // search if a file is present
		System.out.println("Searching...... \n");
		if (files.contains(name)){
			System.out.println("Present \n");
		}
		else {
			System.out.println("File " + name + " not present"+"\n");
		}
	}


	
	public static void main(String[] args) {               // main method
		files.add("t1.txt");
		files.add("t2.txt");
		files.add("t3.txt");
		
		
		try {												// try is for handling InputMismatchException
		
		System.out.println("---------------------------------------");
		System.out.println("LockedMe.com");
		System.out.println("----------Developed by: Saurav Kumar");
		System.out.println("--------------------------------------- \n");
		disp_Page();
		disp_choose(sc);
			
		sc.close();
	}catch (InputMismatchException e) {
		System.out.println("Wrong input.");	  //if the user gives wrong input type (eg char inplace of int) then the program exits
	}
	}

	

	private static void disp_Page() {					// The first page options
		System.out.println("Choose An Option");
		System.out.println("------------------");

		System.out.println("1: View files");
		System.out.println("2: Edit files");
		System.out.println("3: Exit");
		
	}
	
	private static void disp_choose(Scanner sc) {          // Method to input the user choice and display; for display page
		int switchVal=sc.nextInt();
		switch(switchVal) {
		case 1:
			System.out.println("All files are:  \n");
			displayDir();
			disp_Page();
			disp_choose(sc);
			break;
		case 2:
			chooseOption();
			second_choose(sc);
			break;
		case 3:
			System.out.println("Thank you");
			break;
		default:
			System.out.println("Select a valid option \n");
			disp_Page();
			disp_choose(sc);
		}
		
	}

	private static void chooseOption() {                  // options to be displayed to edit files
		System.out.println("Choose An Option");
		System.out.println("------------------");

		System.out.println("1: Add file");
		System.out.println("2: Delete");
		System.out.println("3: Search");
		System.out.println("4: Main Menu");
	}

	private static void second_choose(Scanner sc) {			// input to edit files
		int switchVal=sc.nextInt();
		switch(switchVal) {
		case 1:
			System.out.println("Enter name of file to add:  ");
			addInDir(sc.next());
			//System.out.println("Adding \n");
			chooseOption();
			second_choose(sc);
			break;
		case 2:
			System.out.println("Enter name of file to delete:  ");
			deleteFromDir(sc.next());
			//System.out.println("Deleting \n");
			chooseOption();
			second_choose(sc);
			break;
		case 3:
			System.out.println("Contents of file are");
			displayDir();
			System.out.println("Enter Name: ");
			searchFile(sc.next());
			chooseOption();
			second_choose(sc);
			break;
		case 4:
			disp_Page();
			disp_choose(sc);
			break;
			
			
		default:
			System.out.println("Select a valid option \n");
			chooseOption();
			second_choose(sc);
			break;
		}
	}
}


