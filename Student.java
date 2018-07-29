/* 
 * Class:  FHC CS 1A
 * Description:  This program contains methods for the Student class called by StudentArrayUtilities
 * 				 and StudentDriver programs.  This program constructs Student objects and provides sortKey functionality.    
 * Due Date:  3/22/2017
 * Name:  Susan Pommer
 * File name:  Student.java  
*/

public class Student {
	
	// Declare variables
	private String lastName;
	private String firstName;
	private int totalPoints; 

	public static final String DEFAULT_NAME = "zz-error";
	public static final int DEFAULT_POINTS = 0;
	public static final int MAX_POINTS = 1000;
   
	// ADDED Part 1
	public static final int SORT_BY_FIRST = 88; 
	public static final int SORT_BY_LAST = 98; 
	public static final int SORT_BY_POINTS = 108; 

	// ADDED sortKey and initialize to default 
	private static int sortKey = SORT_BY_LAST;
   
	// Constructor:  creates a new student record
	// Original Constructor - requires parameters; if not valid, sets to defaults
	// Creates a student object
	// If first name, last name or points due not meet requirements, loads a default
	
	public Student(String last, String first, int points) {	
		if (!setLastName(last))
			lastName = DEFAULT_NAME;
		if (!setFirstName(first))
			firstName = DEFAULT_NAME;
		if (!setPoints(points))
			totalPoints = DEFAULT_POINTS;   
   }

	// Method to assign last name -- calls validString method
	// to check for valid string
	public boolean setLastName(String last) {
		if (!validString(last))
			return false;
		lastName = last;
		return true;
	}

	// Method to assign first name -- calls validString method
	// to check for valid string
	public boolean setFirstName(String first) {
		if (!validString(first))
			return false;
		firstName = first;
		return true;
	}

	// Method to assign last name -- calls validPoints method
	// to check for valid number of points
	public boolean setPoints(int pts) {
		if (!validPoints(pts))
			return false;
		totalPoints = pts;
		return true;
	}
	
	// called by setFirstName and setLastName
	// checks to make sure valid strings -- not null, more than one char, 1st char a letter
	public static boolean validString(String testStr) {
		if (
				testStr != null && testStr.length() > 0 
				&& Character.isLetter(testStr.charAt(0))
		)
			return true;
		else
			return false;
	}

	// called by setPoints
	// checks points to ensure greater than zero and less than or equal to max
	public static boolean validPoints(int testPoints) {
		if (testPoints >= 0 && testPoints <= MAX_POINTS)
			return true;
		return false;
	}
	   
	// Accessor methods
	public String getLastName() { 
		return lastName; 
	}
	public String getFirstName() { 
		return firstName; 
	} 
	public int getTotalPoints() { 
		return totalPoints; 
	}
   
	// toString method -- for each Student object 
	public String toString() {
		String resultString;

		resultString = " "+ lastName 
				+ ", " + firstName
				+ " points: " + totalPoints
				+ "\n";
		
		return resultString;
	}
   
// ADDED METHODS FOR ASSIGNMENT
   
	// ADDED - Mutator method to set the sortKey 
	public static boolean setSortKey(int key) { 
		
   		// Note:  input is provided by StudentDriver program
   		// check to make sure input is a valid option 
	   	if ((key == SORT_BY_FIRST) ||(key == SORT_BY_POINTS) || key == (SORT_BY_LAST)) {
	   		sortKey = key;
	   	}	 	   
	   	return true; 
   }

   	// ADDED - Accessor method to get the sortKey
   	public static int getSortKey() {

   		return sortKey; 
   }
  
   	// ADDED: Method compares two student based on sortKey
   	// modified from original method which has been removed from program 
   	public static int compareTwoStudents(Student firstStud, Student secondStud) { 
   		
   		// Declare return variable
   		int result;
   		
   		// Get the active sortKey
   		int sortKey = getSortKey();
   		   		
   		// Determine is swap is needed, based on active sortKey 
   		// returns a swap result (-1, 0, 1)
   		// calling program should swap only if firstStud > secondStud (result = 1)
	   	switch (sortKey) {
		   	// last name; case insensitive
	   		case 98:  // note:  compareToIgnoreCase returns a -1/0/1 
	   			result = firstStud.lastName.compareToIgnoreCase(secondStud.lastName);
	   			break;
	   		// first name; case insensitive
	   		case 88:  // note:  compareToIgnoreCase returns a -1/0/1 
	   			result = firstStud.firstName.compareToIgnoreCase(secondStud.firstName); 
	   			break;  
	   		// by points
		   	case 108: // as this is an integer, need equations to determine if -1/0/1
		   		if (firstStud.totalPoints > secondStud.totalPoints) {
	   				result = 1;
	   			}	
	   			else if (firstStud.totalPoints < secondStud.totalPoints) {
	   				result = -1; 
	   			}
		   		else {
	   				result = 0;
	   			}	
		   		break; 
		   	default: 
		   		result = -10; 
	   		}		
   		return result;
   }	
}
