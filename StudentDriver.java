/* 
 * Class:  FHC CS 1A
 * Description:  This program drives the creation and modification of an array of students. 
 * 				 Calls methods from Student.java and StudentArrayUtilities.java   
 * Due Date:  3/22/2017
 * Name:  Susan Pommer
 * File name:  StudentDriver.java  
*/

public class StudentDriver {
	
	public static void main (String[] args) {
		int k;
      
		Student[] myClass = { 
			new Student("Fried","Omri", 95), 
			new Student("Hendricks","Keat",123),
			new Student("Jeon","Lewis", 195), 
			new Student("Nguyen","Kim",148),
			new Student("3ow","Myron", 108), 
			new Student("Singleton","Omar",225),
			new Student("Stephanov","Nicolas", 44), 
			new Student("Tuss","Scott",452),
			new Student("Wond","Denise", 295), 
			new Student("Morse","Eddie",321),
			new Student("Shrestha", "Prakash", 402), 
			new Student("Wiseman", "Joseph", 500), 
			new Student("Xie", "Yao", 250),
			new Student("Bourquin", "Madeline", 303), 
			new Student("Chen", "Zefeng", 202), 
			new Student("Ferrari", "Arturo", 444),
			new Student("Burns", "Stephen", 303), 
			new Student("Estrade", "Andrea", 332),
			new Student("Chuc", "Kimberly", 192),
			new Student("Duck", "Donald", 500)
		};
      
		// instantiate a StudArrUtilObject
		StudentArrayUtilities myStuds = new StudentArrayUtilities();
      
		// add students manually and individually
		myStuds.addStudent(new Student("Pommer", "Susan", 102));
		myStuds.addStudent(new Student("Omarali","Ayesha", 295)); 
      
		// if we happen to have an array available, we can add students in loop
		// this add the myClass array of students defined above
		for (k = 0; k < myClass.length; k++)
			myStuds.addStudent(myClass[k]);
		
		System.out.println(myStuds.toString("Before: "));
     
		myStuds.arraySort();
		System.out.println(myStuds.toString("Sorting by default: "));
 
		if (Student.setSortKey(Student.SORT_BY_FIRST) == true);
			myStuds.arraySort();
			System.out.println(myStuds.toString("Sorting by first name: "));
      
		if (Student.setSortKey(Student.SORT_BY_POINTS) == true);
			myStuds.arraySort();
			System.out.println(myStuds.toString("Sorting by total points: "));
      
		// Test Median Calculation
		System.out.println("Median of evenClass = " +  myStuds.getMedianDestructive() + "\n");
      
      
		// Testing code for adding too many students
		// NOTE:  I THINK THIS CODE IS CORRECT AND SAMPLE RUN IN ASSIGNMENT SHOWS INCORRECT NUMBER
		for (k = 0; k < 100; k++) {
			System.out.println("Array Testing: ");
			if (!myStuds.addStudent(new Student("first", "last", 22))) {
				System.out.println("Full after " + k + " additional adds.");
				break;
    	  }
      } 
      
   }
}
/* ---------------------- Sample Run ------------------------------------
 * Error: Number of students submitted is larger than class size.
Program did not add this student: Kimberly Chuc.

Error: Number of students submitted is larger than class size.
Program did not add this student: Donald Duck.

Before: 
	 Pommer, Susan points: 102
	 Omarali, Ayesha points: 295
	 Fried, Omri points: 95
	 Hendricks, Keat points: 123
	 Jeon, Lewis points: 195
	 Nguyen, Kim points: 148
	 zz-error, Myron points: 108
	 Singleton, Omar points: 225
	 Stephanov, Nicolas points: 44
	 Tuss, Scott points: 452
	 Wond, Denise points: 295
	 Morse, Eddie points: 321
	 Shrestha, Prakash points: 402
	 Wiseman, Joseph points: 500
	 Xie, Yao points: 250
	 Bourquin, Madeline points: 303
	 Chen, Zefeng points: 202
	 Ferrari, Arturo points: 444
	 Burns, Stephen points: 303
	 Estrade, Andrea points: 332

Sorting by default: 
	 Bourquin, Madeline points: 303
	 Burns, Stephen points: 303
	 Chen, Zefeng points: 202
	 Estrade, Andrea points: 332
	 Ferrari, Arturo points: 444
	 Fried, Omri points: 95
	 Hendricks, Keat points: 123
	 Jeon, Lewis points: 195
	 Morse, Eddie points: 321
	 Nguyen, Kim points: 148
	 Omarali, Ayesha points: 295
	 Pommer, Susan points: 102
	 Shrestha, Prakash points: 402
	 Singleton, Omar points: 225
	 Stephanov, Nicolas points: 44
	 Tuss, Scott points: 452
	 Wiseman, Joseph points: 500
	 Wond, Denise points: 295
	 Xie, Yao points: 250
	 zz-error, Myron points: 108

Sorting by first name: 
	 Estrade, Andrea points: 332
	 Ferrari, Arturo points: 444
	 Omarali, Ayesha points: 295
	 Wond, Denise points: 295
	 Morse, Eddie points: 321
	 Wiseman, Joseph points: 500
	 Hendricks, Keat points: 123
	 Nguyen, Kim points: 148
	 Jeon, Lewis points: 195
	 Bourquin, Madeline points: 303
	 zz-error, Myron points: 108
	 Stephanov, Nicolas points: 44
	 Singleton, Omar points: 225
	 Fried, Omri points: 95
	 Shrestha, Prakash points: 402
	 Tuss, Scott points: 452
	 Burns, Stephen points: 303
	 Pommer, Susan points: 102
	 Xie, Yao points: 250
	 Chen, Zefeng points: 202

Sorting by total points: 
	 Stephanov, Nicolas points: 44
	 Fried, Omri points: 95
	 Pommer, Susan points: 102
	 zz-error, Myron points: 108
	 Hendricks, Keat points: 123
	 Nguyen, Kim points: 148
	 Jeon, Lewis points: 195
	 Chen, Zefeng points: 202
	 Singleton, Omar points: 225
	 Xie, Yao points: 250
	 Omarali, Ayesha points: 295
	 Wond, Denise points: 295
	 Burns, Stephen points: 303
	 Bourquin, Madeline points: 303
	 Morse, Eddie points: 321
	 Estrade, Andrea points: 332
	 Shrestha, Prakash points: 402
	 Ferrari, Arturo points: 444
	 Tuss, Scott points: 452
	 Wiseman, Joseph points: 500

Median of evenClass = 272.5

Error: Number of students submitted is larger than class size.
Program did not add this student: last first.

Full after 0 additional adds.
 *  
 */




