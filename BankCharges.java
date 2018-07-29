/* 
 * Class:  FHC CS 1A
 * Description:  This program calculates and displays fees based on user-input monthly check usage
 * Due Date:  2/8/2017
 * Name:  Susan Pommer
 * File name:  BankCharges.java
*/

// import scanner
import java.util.Scanner; 

public class BankCharges {
	public static void main(String[] args) {
		
		// declare, type and initialize variables
		int numberChecks = 0; // user-entered number of checks
		double totalFees = 0.0; // services fees calculated by the program
		
		// declare the four fee levels as constants (so can more easily changes fees later)
		final double FEE_LEVEL_1 = 0.10; // fee level 1 for less than 20 checks
		final double FEE_LEVEL_2 = 0.08; // fee level 2 for 20-39 checks
		final double FEE_LEVEL_3 = 0.06; // fee level 3 for 40-59 checks
		final double FEE_LEVEL_4 = 0.04; // fee level 4 for 60 or more checks
		
		// create Scanner object
		Scanner input = new Scanner(System.in);
		
		// ask user to enter number of check written per month
		System.out.print("Enter the number of checks written this month: ");
		numberChecks = input.nextInt();
		
		// error and exit if user entered negative number
		if (numberChecks < 0) {
			System.out.println("That is not a valid number. Please start again.");
			System.exit(0);}
		
		// calculate bank services fees
		if ((numberChecks >= 0) && (numberChecks < 20))
			totalFees = numberChecks * FEE_LEVEL_1;
		else if ((numberChecks >= 20) && (numberChecks < 40))
			totalFees = numberChecks * FEE_LEVEL_2;
		else if ((numberChecks >= 40) && (numberChecks < 60))
			totalFees = numberChecks * FEE_LEVEL_3;
		else
			totalFees = numberChecks * FEE_LEVEL_4; 
		
		// print out the total fees (properly formatted as dollars and cents and left justified)
		System.out.printf("%21s%-6.2f", "The total fees are: $", totalFees);
	}
}

/*------------------------------------Sample Runs -------------------------
Enter the number of checks written this month: 44
The total fees are: $2.64  

Enter the number of checks written this month: -5
That is not a valid number. Please start again.

Enter the number of checks written this month: 125124
The total fees are: $5004.96
 -------------------------------------------------------------------------*/
