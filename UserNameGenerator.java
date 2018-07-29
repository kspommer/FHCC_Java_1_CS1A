/* 
 * Class:  FHC CS 1A
 * Description:  Practice with strings and random numbers
 * Due Date:  2/8/2017
 * Name:  Susan Pommer
 * File name:  UserNameGenerator.java
 */
//import scanner
import java.util.Scanner;

public class UserNameGenerator {
	public static void main(String[] args) {
		
		// assumptions:  last name is at least five letters long		
		
		// declare and type the required variables
		String firstName; // user-entered first name 
		String lastName; // user-entered last name
		int randomNumb; // randomly generated number
		
		// create a scanner object	
		Scanner input = new Scanner (System.in);
		
		// prompt user to enter first and last name
		System.out.print("Enter your first name: ");
		firstName = input.next(); 
		System.out.print("Enter your last name: ");
		lastName = input.next();
	
		// generate a random number between 10 - 99 
		randomNumb = 10 + (int)(Math.random() * 90);
		
		// print out username composed of:  1st letter of first name + 1st five characters of last name + random number (10 to 99)		
		System.out.println("Username: " + firstName.charAt(0) + lastName.substring(0,5) + randomNumb);

	}
}
/*--------------------------- Sample Run ----------------------------
Enter your first name: Malcolm 
Enter your last name: Mitchell
Username: MMitch60
-------------------------------------------------------------------- */	


