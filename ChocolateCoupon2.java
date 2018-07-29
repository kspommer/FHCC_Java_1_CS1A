/*
 * Class:  FHC CS 1A
 * Description:  This program runs on a POS system and manages a frequent chocolate bar buyer coupon program
 * Due Date:  2/15/17 -- this is second submission (2/17/17) - this version corrects two loops and adds sample runs which I forgot
 * Name:  Susan Pommer
 * File name:  ChocolateCoupon2.java
*/

import java.util.Scanner;

public class ChocolateCoupon2 {

	public static void main(String[] args) {
		
		// Declare, type and initialize variables and constants
		String option; // User-entered main menu option
		String optionLowerCase; // User-entered option converted to lower case
		char optionFirstLetter; // First character of user-entered option after converted to lower case
		char i; // For use in for loop; to use optionFirstChar
		int customerCredit;  // Counter of number of bars customer has purchased
		int numberPurchased; // Number of bars a customer wants to purchase
		String useCredit; // User-entered option to use credits for free bar
		char useCreditFirstLetter; // First character of user-entered option for free bar 
		
		// Create Scanner object
		Scanner input = new Scanner(System.in);
		
		// Initialize key values
		customerCredit = 0;
		optionFirstLetter = ' ';
		
		// Loop to check input / if not p/s) - error/restart loop / if p - logic / if sentinel value (s) - end		
		while (optionFirstLetter != 's') { 
			// Display menu
			System.out.printf("%5s\n%20s\n%13s\n\r", "Menu:", "P (Process Purchase)", "S (Shut down)");		
			option = input.nextLine();	
			
			// Check for empty string 
			while (option.length() < 1)
				option = input.nextLine();
			
			// Find first letter
			optionLowerCase = option.toLowerCase();
			optionFirstLetter = optionLowerCase.charAt(0);
			
			// Loop to take different actions for first letter s, p and not s or p
			while (optionFirstLetter != 'p') {
				// If sentinel value entered
				if (optionFirstLetter == 's') {
					System.out.printf("%21s\n%9s", "System shutting down.", "Good bye."); 
					System.exit(0);	
					break;
				}	
				else {
					System.out.println("*** Use P or S, please. ***\r");
					System.out.printf("%5s\n%20s\n%13s\n", "Menu:", "P (Process Purchase)", "S (Shut down)");
					option = input.nextLine();
					// Check for empty string
					while (option.length() < 1)
						option = input.nextLine();
					// Find first letter
					optionLowerCase = option.toLowerCase();
					optionFirstLetter = optionLowerCase.charAt(0);				
				}	
			}
			
			if (optionFirstLetter == 'p') {
				// Initialize numberPurchased
				numberPurchased = 0;
				
				if (customerCredit >= 7) {
					// Ask user if they would like to use their credits
					for (useCredit = ""; useCredit.length() < 1; useCredit = input.nextLine()) {
						System.out.printf("%50s\n", "You qualify for a free chocolate bar. Would you like to use your credits?  (Y or N) ");
					}
					
					useCreditFirstLetter = useCredit.charAt(0);
		
					// Calculate action based on user decision
					if (useCreditFirstLetter == 'y' || useCreditFirstLetter == 'Y') {
						customerCredit = customerCredit - 7;
						System.out.println("You have used 7 credits and have " + customerCredit + " left.\nEnjoy your free chocolate bar!\n");
					}	
					else if (useCreditFirstLetter == 'n' || useCreditFirstLetter == 'N') {
						// Ask user how many they would like to purchase
						System.out.println("How many chocolate bars would you like to buy? "); 
						numberPurchased = input.nextInt(); 
						
						// Check for negative input
						if (numberPurchased <= 0) {
							System.out.println("Error\r");
							//continue;
						}	
						// Valid input
						else if (numberPurchased > 0) {
							// Calculate new total
							customerCredit += numberPurchased;			
							// Print out number of coupons and total coupons
							System.out.println("You just earned " + numberPurchased + " coupons and have a total of " + customerCredit + " to use.\n");	
						} 
					}	
					else {
						System.out.println("*** Invalid Response ***"); 		
					}
				}
				else if (customerCredit < 7) {
					// Ask user how many they would like to purchase
					System.out.println("How many chocolate bars would you like to buy? "); 
					numberPurchased = input.nextInt(); 
					
					// Check for negative input
					if (numberPurchased <= 0) {
						System.out.println("Error\r");
						continue;
					}	
					else if (numberPurchased > 0) {
						// Calculate new total
						customerCredit += numberPurchased;			
						// Print out number of coupons and total coupons
						System.out.println("You just earned " + numberPurchased + " coupons and have a total of " + customerCredit + " to use.\n");	
					} 				
				}				
			}	
		}
	}
}			

/* ---------------------------- Sample Runs -----------------
Menu:
P (Process Purchase)
S (Shut down)
dog

*** Use P or S, please. ***

Menu:
P (Process Purchase)
S (Shut down)
peter piper
How many chocolate bars would you like to buy? 
4
You just earned 4 coupons and have a total of 4 to use.

Menu:
P (Process Purchase)
S (Shut down)
p

How many chocolate bars would you like to buy? 
4
You just earned 4 coupons and have a total of 8 to use.

Menu:
P (Process Purchase)
S (Shut down)
PROBLEM

You qualify for a free chocolate bar. Would you like to use your credits?  (Y or N) 
n
How many chocolate bars would you like to buy? 
5
You just earned 5 coupons and have a total of 13 to use.

Menu:
P (Process Purchase)
S (Shut down)
dog

*** Use P or S, please. ***

Menu:
P (Process Purchase)
S (Shut down)
***
*** Use P or S, please. ***

Menu:
P (Process Purchase)
S (Shut down)
P
You qualify for a free chocolate bar. Would you like to use your credits?  (Y or N) 
y
You have used 7 credits and have 6 left.
Enjoy your free chocolate bar!

Menu:
P (Process Purchase)
S (Shut down)
p

How many chocolate bars would you like to buy? 
14
You just earned 14 coupons and have a total of 20 to use.

Menu:
P (Process Purchase)
S (Shut down)
s

System shutting down.
Good bye.

*/