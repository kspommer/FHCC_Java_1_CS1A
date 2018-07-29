/* 
 * Class:  FHC CS 1A
 * Description:  This program makes makes modifications to the Account.java program:  
 * 				 overload constructors and methods, add methods, add static variables
 * Due Date:  3/8/2017
 * Name:  Susan Pommer
 * File name:  Account.java
*/

//*******************************************************
// Account.java
//
// A bank account class with methods to deposit, withdraw, 
// and check the balance.
//*******************************************************

public class Account {
    private double balance;
    private String name;
    private long acctNum;

// Declare and initialize added variables
    private double fee = 0; // My bank opts not to charge fees 
    private static int numAccounts = 0; 

    private static int numberDeposits; 
    private static double totalOfDeposits; 
    private static int numberWithdrawls; 
    private static double totalOfWithdrawls; 
  
//----------------------------------------------  
  // Constructors
//----------------------------------------------  
  // Constructor (option b) -- initializes balance and owner; generates random account number
    public Account(double initBal, String owner, int numAccounts) {
    	balance = initBal;
    	name = owner;
    	acctNum = (int) (Math.random() * Integer.MAX_VALUE);
    	
    	//numAccounts += numAccounts
    	numAccounts++; 
  }

  // Constructor (option a) -- initializes balance, owner and account number per spec
    public Account(double initBal, String owner, int number, int numAccounts) {
    	balance = initBal;
    	name = owner;
    	acctNum = number;
    	
    	//numAccounts += numAccounts
    	numAccounts++;  
    }

  // Constructor (option c) -- initializes owner per spec, initializes balance to zero, 
  // randomly generates account number
   
    public Account(String owner, int numAccounts) {
    	balance = 0;
    	name = owner;
    	acctNum = (int) (Math.random() * Integer.MAX_VALUE);
    	
    	//numAccounts += numAccounts; 
    	numAccounts++;
    }

// ----------------------------------------------
    // Method to reset counters
// ----------------------------------------------    
    public static void resetCounters() {
    	numberDeposits = 0;
    	totalOfDeposits = 0; 
    	numberWithdrawls = 0;
    	totalOfWithdrawls = 0; 
    }

//----------------------------------------------    
  // Method to get the total number of accounts //
//----------------------------------------------    
    public static int getNumAccounts() { 	
    	return numAccounts;
    }
    
       
//----------------------------------------------
  // Withdraw method 1
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
//----------------------------------------------
    public void withdraw(double amount) {
    	if (balance >= amount) {
    		balance -= amount;
    		
    		// Increments the number of Withdrawls and Total of Withdrawls
        	numberWithdrawls++;
        	totalOfWithdrawls = totalOfWithdrawls + amount;			
    	}
    	else
    		System.out.println("Insufficient funds"); 
    }

//----------------------------------------------
// Withdraw method 2
// Checks to see if balance is sufficient for withdrawal.
// If so, decrement balance by amount and fee if not, prints message.   
//----------------------------------------------    
    public void withdraw(double amount, double fee) {
    	double transactionFee = fee; 
    	
    	if (balance >= amount) {
    		balance -= amount;
    		balance -= transactionFee;
    		
    	   	// Increments the number of Withdrawls and Total of Withdrawls
        	numberWithdrawls++;
        	totalOfWithdrawls = totalOfWithdrawls + amount;
    	} 	
    	else
    		System.out.println("Insufficient funds"); 
    }

//----------------------------------------------
    // Adds deposit amount to balance
//----------------------------------------------
    public void deposit(double amount) {
      	balance += amount;
      	// Increments the number of Deposits and Total of Deposits
      	numberDeposits++;
      	totalOfDeposits = totalOfDeposits + amount; 
      }     
        
// ADDED ----------------------------------------------
    // Returns the number of deposits
//----------------------------------------------
    public static int getNumDeposits() {
   		return numberDeposits;
   	}

// ADDED ----------------------------------------------
    // Returns the total value of all deposits
//----------------------------------------------
    public static double getTotalDepositsValue() {
   		return totalOfDeposits; 
   	}
   
// ADDED ----------------------------------------------
    // Returns the number of withdrawls
//----------------------------------------------
    public static int getNumWithdrawls() {
   		return numberWithdrawls;
   	} 
 
// ADDED ----------------------------------------------
    // Returns the total value of all withdrawls
//----------------------------------------------
    public static double getTotalWithdrawlsValue() {
   		return totalOfWithdrawls; 
   	}

//----------------------------------------------
  // Returns balance
//----------------------------------------------
 	public double getBalance() {
 		return balance;
 	}

//----------------------------------------------
  // Returns account number
//----------------------------------------------
 	public double getAcctNumber() {
 		return acctNum;
 	}
 	
//----------------------------------------------
  // Returns a string containing the name, acct number, and balance.
  // NOTE:  original toString edited to provide account information in requested order 	
//----------------------------------------------
 	public String toString() {
 		return "Account number: " + acctNum + 
 			"\nAccount owner: " + name + 
 			"\nAccount balance: " + balance;
 		}
 	}
