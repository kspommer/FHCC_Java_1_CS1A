/* 
 * Class:  CS 1A
 * Description:  Program simulates a bank transaction
 * Due Date:  2/1/2017
 * Name:  Susan Pommer
 * File name:  BankTransaction.java
 */
import java.util.Scanner;

public class BankTransaction {
	public static void main(String[] args) {
		
		//Initialize scanner
		Scanner input = new Scanner(System.in);
		
		//Declare and type the variables
		double checkingBalance, savingsBalance;
		double amount = 0.0;
		int bankingOption, transactionType = 0;
		
		//Ask for initial balance of checking account and present error if balance < 0
		System.out.print("Enter the initial balance for checking:  ");
		checkingBalance = input.nextDouble();
		if (checkingBalance < 0) {	
			System.out.print("That's not a valid amount.  You'll need to start again.");
			System.exit(0);}
		
		//Ask for initial balance of savings account and present error if balance < 0
		System.out.print("Enter the initial balance for savings:  ");
		savingsBalance = input.nextDouble();
		if (savingsBalance < 0) {	
			System.out.print("That's not a valid amount.  You'll need to start again.");
			System.exit(0);}	
		
		//Ask for banking option:  Deposit or Withdraw
		System.out.print("Deposit or withdraw?  1) Deposit or 2) Withdraw " );		
		bankingOption = input.nextInt();
			
		//Ask for account:  Checking or Savings; check for valid user-entered banking option
		if ((bankingOption == 1) || (bankingOption == 2)) {
			System.out.print(((bankingOption == 1) ? "Deposit to: " : "Withdraw from: ") + "1) Checking or 2) Savings? " );
			transactionType = input.nextInt();}
		else {	
			System.out.print("That's not an available option.  You'll need to start again.");
			System.exit(0);}
	
		//Check for valid transaction type answer; check for valid user-entered transaction type; ask for amount to be input
		if (transactionType == 1 || transactionType == 2) {
			System.out.print(((bankingOption == 1) ? "Deposit" : "Withdraw") + " how much? ");
			amount = input.nextDouble();}
		else {
			System.out.print("That's not an available option. You'll need to start again.");
			System.exit(0); }		
		
		//Check that amount is valid
		if (amount <= 0) {
				System.out.print("That's not a valid amount.  You'll need to start again.");
				System.exit(0);}
		
		//Calculate new balances
		if (bankingOption == 1 && transactionType == 1)
			checkingBalance = checkingBalance + amount;	

		else if (bankingOption == 1 && transactionType == 2)
			savingsBalance = savingsBalance + amount;

		//Check that withdraw amount is not greater than balance
		else if (bankingOption == 2 && transactionType == 1)			
			if (checkingBalance - amount < 0)
				System.out.print("You can't do that -- there isn't that much money in the account!\n");
			else
				checkingBalance = checkingBalance - amount;
		
		else if (bankingOption == 2 && transactionType == 2)
			if (savingsBalance - amount < 0) 
				System.out.print("You can't do that -- there isn't that much money in the account!\n");
			else
				savingsBalance = savingsBalance - amount;

		//Print Savings and Checking balances
		System.out.println("After the transaction: \n\tSavings balance: " 
		+ savingsBalance + "\n\tChecking balance: " + checkingBalance);  
	}
}
				
/*---------------------------------------Sample Run---------------------------------------------------------
Run 1: 
Enter the initial balance for checking:  3000
Enter the initial balance for savings:  2000
Deposit or withdraw?  1) Deposit or 2) Withdraw 1
Deposit to: 1) Checking or 2) Savings? 1
Deposit how much? 200
After the transaction: 
	Savings balance: 2000.0
	Checking balance: 3200.0

Run 2: 
Enter the initial balance for checking:  2000
Enter the initial balance for savings:  1000
Deposit or withdraw?  1) Deposit or 2) Withdraw 1
Deposit to: 1) Checking or 2) Savings? 2
Deposit how much? 3000
After the transaction: 
	Savings balance: 4000.0
	Checking balance: 2000.0
	
Run 2b: 
Enter the initial balance for checking:  2000
Enter the initial balance for savings:  1000
Deposit or withdraw?  1) Deposit or 2) Withdraw 2
Withdraw from: 1) Checking or 2) Savings? 2
Withdraw how much? 3000
You can't do that -- there isn't that much money in the account!
After the transaction: 
	Savings balance: 1000.0
	Checking balance: 2000.0

Run 3: 
Enter the initial balance for checking:  4000
Enter the initial balance for savings:  2000
Deposit or withdraw?  1) Deposit or 2) Withdraw 2
Withdraw from: 1) Checking or 2) Savings? 2
Withdraw how much? 400
After the transaction: 
	Savings balance: 1600.0
	Checking balance: 4000.0

Susan's Own Run: 
Enter the initial balance for checking:  1000000
Enter the initial balance for savings:  10000
Deposit or withdraw?  1) Deposit or 2) Withdraw 1
Deposit to: 1) Checking or 2) Savings? 2
Deposit how much? 1000000
After the transaction: 
	Savings balance: 1010000.0
	Checking balance: 1000000.0
 -------------------------------------------------------------------------------------------------------*/

