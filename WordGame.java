/* 
 * Class:  CS 1A
 * Description:  Prompt user for input and display a story including that input
 * Due Date:  1/25/2017
 * Name:  Susan Pommer
 * File name:  WordGame.java
 */

// Import the Scanner class of the java.util library so its functionality can be used by the program
import java.util.Scanner;

public class WordGame {
	public static void main(String[] args) {
	
		// Create Scanner object that reads user input from keyboard
		try (Scanner input = new Scanner(System.in)) {  //To address 'resource leak' error; solution from stackoverflow.com
	
		// Declare seven user input variables and their types; all strings as age not used in a calculation
		String name, age, city, college, profession, animal, petName;
		
		// Prompt user for seven inputs (println allows for multiple word answers)
		System.out.println("Enter your name: (e.g. Bob)");
		name = input.nextLine();
		
		System.out.println("Enter your age: (e.g. 34)");
		age = input.nextLine(); 
		
		System.out.println("Enter the name of a city: (e.g. Miami)");
		city = input.nextLine();
		
		System.out.println("Enter the name of a college: (e.g. Mississippi State)");
		college = input.nextLine();
		
		System.out.println("Enter a profession: (e.g. musician)");
		profession = input.nextLine();
		
		System.out.println("Enter a type of animal: (e.g. tiger)");
		animal = input.nextLine();
			
		System.out.println("Enter a pet's name:  (e.g. Spot)");
		petName = input.nextLine();
		System.out.println();
		
		// Print the summary statement which includes the user input data
		System.out.println("There once was a person named " + name + " who lived in " + city + 
				".  At the age of \n" + age + ", " + name + " went to college at " + college + ".  " + 
				name + " graduated \nand went to work as a " + profession + ".  Then, " + name + 
				" adopted a(n) " + animal + "\nnamed " + petName + ".  They both lived happily ever after.");
		}		
	}
}
/*---------------------------------------sample Run---------------------------------------------------------
* Enter your name: (e.g. Bob)
* Bob Johnson
* Enter your age: (e.g. 34)
* 18
* Enter the name of a city: (e.g. Miami)
* Minneapolis
* Enter the name of a college: (e.g. Mississippi State)
* The University of Minnesota
* Enter a profession: (e.g. musician)
* college and Olympic hockey coach
* Enter a type of animal: (e.g. tiger)
* beaver
* Enter a pet's name:  (e.g. Spot)
* Amik
*
* There once was a person named Bob Johnson who lived in Minneapolis.  At the age of 
* 18, Bob Johnson went to college at The University of Minnesota.  Bob Johnson graduated 
* and went to work as a college and Olympic hockey coach.  Then, Bob Johnson adopted a(n) beaver
* named Amik.  They both lived happily ever after.
*
* --------------------------------------------------------------------------------------------------------*/