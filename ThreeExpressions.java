/* 
 * Class:  CS 1A
 * Description:  Computes and displays three values based on user data
 * Due Date:  1/25/2017
 * Name:  Susan Pommer
 * File name:  FirstExpressions.java
 */

public class ThreeExpressions 
{
	public static void main(String[] args) 
	{
		//store personal data in integer variables
		// NOTE:   I have changed my ID when posting on GitHub
		// so program will not yield same results as sample output
		int myId = 10810822;
		int numLet = 5;		 
		
		//display user personal data
		System.out.println("My first name is Susan");
		System.out.println("My Student ID is " + myId);
		System.out.println("The number of characters in my first name is " + numLet);
		System.out.println ("");
		
		// calculate Expression 1 and display output
		int intResult = myId % 17;
		System.out.println("Expression #1 --> " + intResult);	
		System.out.println ("");
				
		// calculate Expression 2 and display output
		intResult = (numLet + 17) % 11;
		System.out.println("Expression #2 --> " + intResult);
		System.out.println ("");
		
		// 	calculate Expression 3 and display output
		double doubleResult = myId / (numLet + 800.);
		System.out.println("Expression #3 --> " + doubleResult);
		System.out.println ("");
	}
}

/*-----------------------------------sample run---------------------------------
*My first name is Susan
*My Student ID is 108*****
*The number of characters in my first name is 5
* 
*Expression #1 --> 0
*
*Expression #2 --> 0
*
*Expression #3 --> 13446.408695652173
-------------------------------------------------------------------------------*/
