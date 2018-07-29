/* 
 * Class:  FHC CS 1A
 * Description:  This program initializes the array of students objects, adds student objects to the array, 
 * 				 and drives sorting of students based on a comparison driven by a sortKey
 * Due Date:  3/22/2017
 * Name:  Susan Pommer
 * File name:  StudentArrayUtilities.java
*/

public class StudentArrayUtilities {
	
	// ADDED:  Declare the private array
	private Student[] theArray;
	String title; 
	
	// ADDED:  define max number of students
	private final int MAX_STUDENTS = 20;
	
	// ADDED:  counter of number of students in the array at a point in time
	// increases as add students using addStudent;
	private int numStudents;
	
	// ADDED:  Constructor -- Creates an initially empty array 
	// fixed for max number of students
	
	public StudentArrayUtilities() {	
		theArray = new Student[MAX_STUDENTS];
		numStudents = 0; 	
	}
	
	// method to add students to theArray
	public boolean addStudent(Student stud) {	
		// variables
		String first, last; 
		int pts;
		
		// test stud for null values
		first = stud.getFirstName();
		if (Student.validString(first) == false)
			return false;

		last = stud.getLastName();
		if (Student.validString(last) == false)
			return false;

		pts = stud.getTotalPoints();
		if (Student.validPoints(pts) == false)
			return false;
		
		// If valid, add a student to the array 
		if (numStudents < theArray.length) {
			theArray[numStudents] = stud;	
			numStudents++; 
			return true; 
		}	
		else  {
			System.out.println("Error: Number of students submitted is larger than class size.");
			System.out.println("Program did not add this student: " + stud.getFirstName() + " " + stud.getLastName() + ".\n");
			return false; 
		}	
	}
	
	// ADDED:  public arraySort -- reviews the internal array (theArray)
	public void arraySort() {
		boolean changed = true; 
		int highestNonNullIndex = numStudents - 1;
		
		// call method, which in turn calls largest to top method which in loop calls comparison method
		// want to sort each item in array versus all other items in array (up to null value) by sortKey
		for (int k = 0; k <= highestNonNullIndex; k++) 
			if (changed == true) 
				floatLargestToTop(highestNonNullIndex);
			else
				break;
	}
 	
	private boolean floatLargestToTop(int top) { // arraySort calls this method; passes it the number of Students  
 		boolean changed = false;
		Student temp;
		
		// compare first student in the array against other students based on sortKey until swap made;
		for (int i = 0; i < top; i++)
			for (int j = i + 1; j <= top; j++)
				if (Student.compareTwoStudents(theArray[i], theArray[j]) > 0) {  
					temp = theArray[i];
					theArray[i] = theArray[j];
					theArray[j] = temp;
					changed = true;
					break; 
				}
		return changed;
	}
	
	// ADDED: Computes and returns the median of all student scores
	// ignores null students in the array
	public double getMedianDestructive() {
		
		// Declare variables
		double median = 0.0;
		int middleIndex = -1;  
		Student stud;  
		int saveSortKey; 
		Student middleStud; 
		Student middleStud2;
		
		// Save current sortKey 
		saveSortKey = Student.getSortKey();
		
		// Change sortKey to SORT_BY_POINTS
		Student.setSortKey(Student.SORT_BY_POINTS); 
		
		// Sort array 
		if (Student.setSortKey(Student.SORT_BY_POINTS) == true);
			arraySort();

		// Dispose of cases where array has 0 or one element
		if (numStudents == 0)
			median = 0.0; 	
		else if (numStudents == 1) { 	
			stud = theArray[0];
			median = stud.getTotalPoints(); 
		}	
		// Calculate median when even number of students
		else if (numStudents % 2 == 0) {
			middleIndex = numStudents / 2; 
			middleStud = theArray[middleIndex]; 
			middleStud2 = theArray[middleIndex-1];
			median = ((middleStud.getTotalPoints() + middleStud2.getTotalPoints()) / 2.0); 		
		}	
		// Calculate median when odd number of students	
		else {
			middleIndex = (numStudents - 1) / 2; 
			middleStud = theArray[middleIndex];
			median = (middleStud.getTotalPoints() / 1.0);
		}	
		// reset sortKey to original value 
		Student.setSortKey(saveSortKey); 
			
		return median; 	
	}
	
 	// ADDED:  Returns the entire array in a single String without need for array parameter
	// Printed by StudentDriver program 
	public String toString(String title) {
		// user foreach loop to build a string of the student data
		String outputString = title + "\n";  
		
		for (Student stud: theArray) {
			if (stud == null)
				break; 
			
			outputString = (outputString + "\t" + stud.toString());	
			
		}
		return outputString; 
	}	
}


