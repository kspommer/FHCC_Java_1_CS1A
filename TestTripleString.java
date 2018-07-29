/* 
 * Class:  FHC CS 1A
 * Description:  This program practices classes and object by creating, validating, mutating and assessing 
 *               a string comprised of three separate strings.  (This was really hard!!!)
 * Due Date:  3/3/2017
 * Name:  Susan Pommer
 * File name:  TestTripleString.java
*/

import java.util.*; 
import java.lang.Math;

public class TestTripleString {
	// Test the TripleString class methods / functionality
	
	public static void main(String[] args) {
		
	// Instantiate four TripleString objects; each has three data fields
	TripleString tripleString1 = new TripleString("", "B", "C");
	TripleString tripleString2 = new TripleString("it's", "easy", "as");	
	TripleString tripleString3 = new TripleString();
	TripleString tripleString4 = new TripleString("one", "two","three");
	
	// Print out TripleString objects after they are created
	System.out.println("TripleStrings after instantiation ------- ");
	System.out.println(tripleString1.toString());
	System.out.println(tripleString2.toString());
	System.out.println(tripleString3.toString());
	System.out.println(tripleString4.toString() + "\n");
	
	// Mutate one or more member of every object
	tripleString1.setString1("CHANGE-A");
	tripleString2.setString2("");
	tripleString3.setString3("CHANGED HERE");
	tripleString4.setString1("CHANGE-UNO");
	
	// Display all objects again (should show mutations) 
	System.out.println("TripleStrings after changes ------- ");
	System.out.println(tripleString1.toString());
	System.out.println(tripleString2.toString());
	System.out.println(tripleString3.toString());
	System.out.println(tripleString4.toString() + "\n");
	
// Execute two explicit mutator tests
	// Call a mutator in an if/else statement which prints one message if successful; another if fails
	
	// Print header
	System.out.println("Mutator Tests ------- ");

// Mutator Test 1 - test for valid variable
	String mutateString = "MUTATED";
	tripleString1.setString1(mutateString);
	
	if (tripleString1.getString1() == mutateString) 
		System.out.println("The mutation has worked successfully.\n");
	else 
		System.out.println("Correctly rejected invalid string.\n");
	
// Mutator Test 2 - test for a varible > 50 character
	String mutateString2 = "123456789012345678901234567890123456789012345678901";
	tripleString3.setString2(mutateString2);
	
	if (tripleString3.getString2() == mutateString2) 
		System.out.println("The mutation has worked successfully.\n");
	else 
		System.out.println("Correctly rejected invalid string.\n");
	
// Mutator Test 3 - test for null variable
		String mutateString3 = "";
		tripleString4.setString3(mutateString3);
		
		if (tripleString4.getString3() == mutateString3) 
			System.out.println("The mutation has worked successfully.\n");	
		else 
			System.out.println("Correctly rejected invalid string.\n");

	
// Make two assessor calls to demonstrate proper operation
	System.out.println("Accessor Tests ------- ");
	System.out.println("tripleString1\t" + "String 1:\t" + tripleString1.getString1());
	System.out.println("tripleString3\t" + "String 2:\t" + tripleString3.getString2());
	System.out.println("tripleString4\t" + "String 3:\t" + tripleString4.getString3());
	}
}	
	
class TripleString {
	
	// Declare public class static constants
	final int MIN_LEN = 1;
	final int MAX_LEN = 50; 
	final String DEFAULT_STRING = "(undefined)";
	
	// Declare private class instance variables 
	private String string1;
	private String string2; 
	private String string3; 	
	
// Default constructor -- sets all instance variables to DEFAULT_STRING
	public TripleString() {
		string1 = DEFAULT_STRING;
		string2 = DEFAULT_STRING;
		string3 = DEFAULT_STRING;
	}

// Constructor:  Parameter-taking constructor method
	public TripleString(String str1, String str2, String str3) {
		boolean checkString;
		
		string1 = str1;
		// check if string is valid
		checkString = validString(string1);
		
		// if invalid string, reset to default
		if (checkString == false)
			string1 = DEFAULT_STRING; 
			
		string2 = str2; 
		// check if string is valid
		checkString = validString(string2);
				
		// if invalid string, reset to default
		if (checkString == false)
			string2 = DEFAULT_STRING;
		
		string3 = str3;
		// check if string is valid
		checkString = validString(string3);
						
		// if invalid string, reset to default
		if (checkString == false)
			string3 = DEFAULT_STRING;
	
	}	
	
// MUTATORS (3x)
	// String mutation:  validate string; replace if meets requirements criteria, else set to DEFAULT_STRING
	// Call validString method for each of string1, string2, string3

	public void setString1(String str) {
		// Invoke string validation method (validString)
		boolean validityCheck;
		validityCheck = validString(str);
		
		// if valid reset string1
		if (validityCheck == true)
			string1 = str;  
		// if not valid, keep current string 
	} 	
	
	public void setString2(String str) {
		// Invoke string validation method (validString)
		boolean validityCheck;
		validityCheck = validString(str);

		// if valid reset string2
		if (validityCheck == true)
			string2 = str;  
		// if not valid, keep current string 
	}
	
	public void setString3(String str) {
		// Invoke string validation method (validString)
		boolean validityCheck;
		validityCheck = validString(str);
	
		// if valid reset string3
		if (validityCheck == true)
			string3 = str;  
		// if not valid, keep current string
	}
	
// Validate string not null / has between 1 and 50 characters	
	public boolean validString(String str) {
		
		// declare and initialize a local variable
		boolean validityTest = false;	
		
		// Check null requirement	
		if (str != null && str.length() == 0)
			validityTest = false;	
		// Check string length requirement
		if (str.length() >= 1 && str.length() <= 50)
			validityTest = true; 
		return validityTest;
	}

// ASSESSORS (3x)
	 
	public String getString1() {
		return string1; 
	}
		
	public String getString2() {
		return string2; 
	}
	
	public String getString3() {
		return string3; 
	}
	
// Returns string representation of all the information in the TripleString object 
	public String toString() {
		return (string1+ "\t" + string2+ "\t" + string3 +"\t");
		
		// Note:  I tried to return fancier formatting using System.out.printf, but could not get it to work at a return value.
		// Would appreciate any reference materials you can provide on this item. 
	}
}	

/*------------------------------------Sample Run -------------------------
 * 
TripleStrings after instantiation ------- 
(undefined)	B	C	
it's	easy	as	
(undefined)	(undefined)	(undefined)	
one	two	three	

TripleStrings after changes ------- 
CHANGE-A	B	C	
it's	easy	as	
(undefined)	(undefined)	CHANGED HERE	
CHANGE-UNO	two	three	

Mutator Tests ------- 
The mutation has worked successfully.

Correctly rejected invalid string.

Correctly rejected invalid string.

Accessor Tests ------- 
tripleString1	String 1:	MUTATED
tripleString3	String 2:	(undefined)
tripleString4	String 3:	three


 -------------------------------------------------------------------------*/


