/* 
 * Class:  FHC CS 1A
 * Description:  This program searches for and replaces or removes a key character from a string
 * Due Date:  2/22/17
 * Name:  Susan Pommer
 * File name:  TextProcessing.java
*/

// import Scanner method
import java.util.Scanner;

public class TextProcessing {
	public static void main(String[] args) {
		
		// Declare universal variables
		char keyCharacter; // User-entered key variable to search for in theString  
		String theString = ""; // User-entered string to be searched

		// Call getKeyCharacter method
		keyCharacter = getKeyCharacter();
	
		// Call getString method
		theString = getString();
		
		// Call maskCharacter (2 parameters)
		System.out.println("String with '" + keyCharacter + "' masked:\n" + maskCharacter(theString, keyCharacter) + "\r");
	
		// Call removeCharacter (2 parameters)
		System.out.println("String with '" + keyCharacter + "' removed:\n" + removeCharacter(theString, keyCharacter) + "\r");

		// Call countKey (2 parameters)
		System.out.println("# " + keyCharacter + "s: " + countKey(theString, keyCharacter) + "\r");
	} 		

	public static int countKey(String theString, char keyCharacter) {
		// declare and initialize variables
		int counter = 0; // Counts number of times the key character is found in theString 
		int index;  // index of a character in theString
		char letter;  // character at each index in theString
		
		// loop - review each character in string for match to keyCharacter
		for (index = 0; index < theString.length(); index ++) {
			letter = theString.charAt(index);
			
			// if character at each index in theString matches the key character, increment the counter
			if (letter == keyCharacter) {
				counter ++;
			}	
			// if character at each index in theString does not match the key character, continue review 
			else { 
				letter = theString.charAt(index);	
			}
		}	
		return counter;		
	}	
	
	public static String removeCharacter(String theString, char keyCharacter) {
		// declare variables
		String newString2 = ""; // String which removes the key character in all places (case sensitive) 
		int index;  // index for a character in theString
		char letter;  // character at each index in theString
		
		// loop to review each character in string for match to keyCharacter
		for (index = 0; index < theString.length(); index ++) {
			letter = theString.charAt(index);
			
			// if character at each index in theString matches the key character, do not add a character to the newString2
			if (letter == keyCharacter) {
				continue; 
			}	
			// if character at each index in theString does not match the key character; letter = existing character and add to newString2
			else { 
				letter = theString.charAt(index);	
			}
			newString2 = newString2 + letter;	
		}	
		return newString2;	
	}
	
	public static String maskCharacter(String theString, char keyCharacter) {
		// declare variables
		String newString = ""; // String which replaces key character with $ in all places (case sensitive)
		int index;  // index for a character in theString
		char letter;  // character at each index in theString
		
		// loop - review each character in string for match to keyCharacter
		for (index = 0; index < theString.length(); index ++) {
			letter = theString.charAt(index);
			
			// if character at each index in theString matches the key character, assign letter = $
			if (letter == keyCharacter) {
				letter = '$';
			}	
			// if character at each index in theString does not match the key character, assign letter = existing character
			else { 
				letter = theString.charAt(index);	
			}
			
			newString = newString + letter;		
		}	
		return newString;	
	}
	
	public static String getString() {
		// create Scanner object
		Scanner input = new Scanner(System.in);
		
		//declare and initialize variables
		String theString = ""; // User-entered string to be searched for key character
		final int REQUIRED_STRING_LENGTH = 4;
		
		// Ask for user input of theString
		while (theString.length() < REQUIRED_STRING_LENGTH) {	
			System.out.println("Please enter a phrase or sentence with >=4 and <=500 characters: ");
			theString = input.nextLine();	
			// check if newString has required number of characters; return error if < 4
			if (theString.length() < REQUIRED_STRING_LENGTH) {
				System.out.println("Error, please try again.");	
			}
		}
		return theString;
	}
	
	public static char getKeyCharacter() {
		// create Scanner object
		Scanner input = new Scanner(System.in);

		// declare variables
		String keyCharacterAsString = ""; // User-entered key variable (as a String) 
		char keyCharacter; // User-entered key variable to search for in theString (as a character)
		
		// Ask for user input of keyCharacter
		while (keyCharacterAsString.length() != 1) {	
			System.out.println("Please enter a SINGLE character to act as key: ");
			keyCharacterAsString = input.next();	
			// Check to see if single character
			if (keyCharacterAsString.length() != 1) {
				System.out.println("Error, please try again.");
			}			
		}	
		// Convert single character string to character	
		keyCharacter = keyCharacterAsString.charAt(0);	
		
		// Return keyCharacter;
		return keyCharacter;
	}	
}

/*---------------------------------------Sample Runs ---------------------------------------
Run 1: 
-------
Please enter a SINGLE character to act as key: 
SS
Error, please try again.
Please enter a SINGLE character to act as key: 
&&
Error, please try again.
Please enter a SINGLE character to act as key: 
55
Error, please try again.
Please enter a SINGLE character to act as key: 
S
Please enter a phrase or sentence with >=4 and <=500 characters: 
She sells sea shells in South San Francisco.   she sells sea shells in south san francisco.   SHE SELLS SEA SHELLS IN SOUTH SAN FRANCISCO. 
String with 'S' masked:
$he sells sea shells in $outh $an Francisco.   she sells sea shells in south san francisco.   $HE $ELL$ $EA $HELL$ IN $OUTH $AN FRANCI$CO. 

String with 'S' removed:
he sells sea shells in outh an Francisco.   she sells sea shells in south san francisco.   HE ELL EA HELL IN OUTH AN FRANCICO. 

# Ss: 12


Run 2: 
-------
Please enter a SINGLE character to act as key: 
%
Please enter a phrase or sentence with >=4 and <=500 characters: 
I%have%not%taken%an%exam%in%10%years. 
String with '%' masked:
I$have$not$taken$an$exam$in$10$years. 

String with '%' removed:
Ihavenottakenanexamin10years. 

# %s: 8

Run 3: 
------
Please enter a SINGLE character to act as key: 
3
Please enter a phrase or sentence with >=4 and <=500 characters: 
33 quick brown foxes jumped over 3623 brown dogs at 333 Victoria Lane. 
String with '3' masked:
$$ quick brown foxes jumped over $62$ brown dogs at $$$ Victoria Lane. 

String with '3' removed:
 quick brown foxes jumped over 62 brown dogs at  Victoria Lane. 

# 3s: 7

*/

