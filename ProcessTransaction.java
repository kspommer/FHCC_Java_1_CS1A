/* 
 * Class:  FHC CS 1A
 * Description:  This program creates bank accounts and processes deposits and withdraws. 
 * Due Date:  3/8/2017
 * Name:  Susan Pommer
 * File name:  ProcessTransaction.java
*/

import java.util.*; 
import java.util.Scanner;

public class ProcessTransaction {

	public static void main(String[] args) {
	    // Declare local variables
	    int accountNumber; 
	    
	    String transactionType; 
	    String transactionTypeLowerCase;
	    char transactionTypeLowerCaseChar;
	    
	    String moreTransactions; 
	    String moreTransactionsLowerCase;
	    char moreTransactionsLowerCaseChar;
	    
	    String continueAnotherDay; 
	    String continueAnotherDayLowerCase; 
	    char continueAnotherDayLowerCaseChar = 'y';
	    
	    // Declare account variables
	    double transactionAmount; 
	    int accountOneAcctNumber;
	    int accountTwoAcctNumber;
	    
	    // Initialize and initialize
	    int numberAccounts = 0;
	    
	    // Initialize scanner 
	    Scanner input = new Scanner(System.in);
	    
	    // Construct two bank accounts objects
	    // using constructor b:
	    Account accountOne = new Account(1000, "Doug McKenzie", numberAccounts); 
	    // using constructor a:
	    Account accountTwo = new Account(1000, "Bob McKenzie", 123456, numberAccounts);
	    
	    // Print opening statement
	    System.out.println("There are 2 accounts");
	    
	    // Launch loop for user to enter account deposits / withdrawls per day
	    while (continueAnotherDayLowerCaseChar == 'y') {
	  
		    // Print each account's details (number, owner and balance) at start of the business day
		    System.out.println("The following accounts are available: \n");
		    System.out.println(accountOne + "\n");
			System.out.println(accountTwo + "\n");
		    
			// Initialize loop sentinel value	
		    moreTransactionsLowerCaseChar = 'y';
		    
		    // Launch loop for user to enter account deposits / withdrawls for the day
		    while (moreTransactionsLowerCaseChar == 'y') {
	    	
				// Request user input: Account Number	
		    	System.out.print("Enter the number of the account your would like to access: ");
		    	accountNumber = input.nextInt();
		    
		    	// Request user input: Deposit or Withdraw
		    	System.out.print("Would you like to make a deposit (D) or withdrawl (W)? ");
		    	transactionType = input.next();		
		    	transactionTypeLowerCase = transactionType.toLowerCase();
		    	transactionTypeLowerCaseChar = transactionTypeLowerCase.charAt(0);
		    
		    	// Request user input: Enter Amount
		    	System.out.print("Enter the amount: ");
		    	transactionAmount = input.nextDouble();  	
		    
		    	// Get Account Numbers
		    	accountOneAcctNumber = (int)accountOne.getAcctNumber();  
		    	accountTwoAcctNumber = (int)accountTwo.getAcctNumber();
	    	
		    	// If user enters account one number, execute deposit or withdrawl
		    	if (accountNumber == accountOneAcctNumber) {
		    		if (transactionTypeLowerCaseChar == 'd') { 
		    			// Deposit to account one; increment deposit counters
		    			accountOne.deposit(transactionAmount); 
		    			accountOne.getBalance();
		    		}	
		    		else if (transactionTypeLowerCaseChar == 'w') {
		    		// Withdrawl from account one; increment withdrawl counters
		    			accountOne.withdraw(transactionAmount);
		    			accountOne.getBalance();
		    		}	
		    		else {
		    			System.out.println("That's not a valid option.");
		    		}	
		    	}	
		    	
		    	// If user enters account two number, execute deposit or withdrawl
		    	else if (accountNumber == accountTwoAcctNumber) { 	
		    		// Deposit to account two; increment deposit counters
		    		if (transactionTypeLowerCaseChar == 'd') {
		    			accountTwo.deposit(transactionAmount);
		    			accountTwo.getBalance();	    
		    		}
		    		// Withdrawl from account two; increment withdrawl counters
		    		else if (transactionTypeLowerCaseChar == 'w') {
		    			accountTwo.withdraw(transactionAmount);
		    			accountTwo.getBalance();
		    		} 
		    		else { 
		    			System.out.println("That's not a valid option.\n");
		    			continue;
		    		}	
		    	}		
		    	
		    	// If user enters a non-valid account number, provide error and loop
		    	else if ((accountNumber != accountOneAcctNumber) && (accountNumber != accountTwoAcctNumber))
		    		System.out.println("Sorry, invalid account number.");
		  
		    	// Loop to validate that use has entered y, Y, n, or N
		    	do { 
			    	// Request user input: Would they like to enter more transactions for today
			    	System.out.print("\nMore transactions? (y/n) ");
			    	moreTransactions = input.next();
			    	moreTransactionsLowerCase = moreTransactions.toLowerCase(); 	
			    	moreTransactionsLowerCaseChar = moreTransactionsLowerCase.charAt(0);
			    	// Ask user for input again if answer not y, Y, n, N
			    	if(moreTransactionsLowerCaseChar == 'y')
			    		break; 
			    	else if (moreTransactionsLowerCaseChar == 'n')
			    		break;
			    	else
		    			System.out.println("That's an invalid entry.  Please try again. "); 	
			    
		    	} while (moreTransactionsLowerCaseChar != 'y' || moreTransactionsLowerCaseChar !='n');
			    
			}	
	
			// Print Summary of Day's Transactions
		    System.out.println("Total number of deposits: " + Account.getNumDeposits());
		    System.out.println("Total number of withdrawls: " + Account.getNumWithdrawls());
		    System.out.println("Total amount of deposits: " + Account.getTotalDepositsValue());
		    System.out.println("Total amount of withdrawls: " + Account.getTotalWithdrawlsValue());
		    
		    // Reset the withdrawl / deposit counters in anticipation of second loop
		    Account.resetCounters();
		
		//Request user input:  Would they like to enter transactions for another day
		System.out.println("\nWould you like to enter transactions for another day? (y/n) ");
		continueAnotherDay = input.next();
		continueAnotherDayLowerCase = continueAnotherDay.toLowerCase(); 	
		continueAnotherDayLowerCaseChar = continueAnotherDayLowerCase.charAt(0);

	    }
	    
	System.out.println("Goodbye");
	System.exit(0);
	}
}

/* ----------------------------------  Sample Runs ----------------------------------------
There are 2 accounts
The following accounts are available: 

Account number: 77861682
Account owner: Doug McKenzie
Account balance: 1000.0

Account number: 123456
Account owner: Bob McKenzie
Account balance: 1000.0

Enter the number of the account your would like to access: 77861682
Would you like to make a deposit (D) or withdrawl (W)? D
Enter the amount: 1000

More transactions? (y/n) y
Enter the number of the account your would like to access: 77861682
Would you like to make a deposit (D) or withdrawl (W)? w
Enter the amount: 200

More transactions? (y/n) y
Enter the number of the account your would like to access: 123456
Would you like to make a deposit (D) or withdrawl (W)? d
Enter the amount: 100

More transactions? (y/n) y
Enter the number of the account your would like to access: 123456
Would you like to make a deposit (D) or withdrawl (W)? w
Enter the amount: 500

More transactions? (y/n) n
Total number of deposits: 2
Total number of withdrawls: 2
Total amount of deposits: 1100.0
Total amount of withdrawls: 700.0

Would you like to enter transactions for another day? (y/n) 
y
The following accounts are available: 

Account number: 77861682
Account owner: Doug McKenzie
Account balance: 1800.0

Account number: 123456
Account owner: Bob McKenzie
Account balance: 600.0

Enter the number of the account your would like to access: 123
Would you like to make a deposit (D) or withdrawl (W)? d
Enter the amount: 500
Sorry, invalid account number.

More transactions? (y/n) y
Enter the number of the account your would like to access: 123456
Would you like to make a deposit (D) or withdrawl (W)? w
Enter the amount: 500

More transactions? (y/n) y
Enter the number of the account your would like to access: 77861682
Would you like to make a deposit (D) or withdrawl (W)? d
Enter the amount: 123

More transactions? (y/n) y
Enter the number of the account your would like to access: 77861682
Would you like to make a deposit (D) or withdrawl (W)? 200
Enter the amount: 200
That's not a valid option.

More transactions? (y/n) y
Enter the number of the account your would like to access: 77861682
Would you like to make a deposit (D) or withdrawl (W)? w
Enter the amount: 200

More transactions? (y/n) n
Total number of deposits: 1
Total number of withdrawls: 2
Total amount of deposits: 123.0
Total amount of withdrawls: 700.0

Would you like to enter transactions for another day? (y/n) 
n
Goodbye

*/