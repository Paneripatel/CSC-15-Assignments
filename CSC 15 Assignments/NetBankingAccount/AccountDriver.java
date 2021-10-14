/****Paneri Patel****/
/****Csc 15****/
import java.io.*;
import java.util.*;
public class AccountDriver {
    public static void main (String[] args) throws Exception{
	  Account[] accounts = new Account[100];
	  fillArray(accounts);
	  
     //Yes no method
	  String userInput = "yes";
	  Scanner kb = new Scanner(System.in);
	  System.out.println("Welcome to the bank of America\n");
	  
	  while(userInput.equals("yes")) {
		  
		  run(accounts, kb);
		  
		  System.out.print("Thanks for being a valued customer. See you soon\n"
		  		+ "is there another person in line: ");
		  
		  kb = new Scanner(System.in);
		  userInput = getYesNo(kb);
		  
	  }
	  System.out.println("Good Bye");
	  
  }
    //Run method
    public static void run(Account[] accounts , Scanner kb) throws IOException
  {
      System.out.print("Enter your account number: ");
      
      while(!kb.hasNextInt()) {
    	  System.out.print("Enter your account number: ");
    	  kb.next();
      }
      
      int id = kb.nextInt();
      
      
      
      if(validateAccount(accounts, id)){
    	  System.out.println("*******************************************");
    	  int userInput = -1;
    	  
    	  while(userInput != 0) {
    	  
    		  menu();
    	  
    		  userInput = kb.nextInt();
    	  
    		  if(userInput==1) {
    			  balance(accounts, kb, id);
    		  }
    		  else if(userInput==2) {
    			  deposit(accounts, kb, id);
    		  }
    		  else if(userInput==3) {
    			  withdraw(accounts, kb, id);
    		  }
    		  else if(userInput==4) {
    			  
    			  for(int i=0; i<100; ++i) {
    		    		Account a1 = accounts[i];
    		    		if(a1 != null && a1.getId()==id) {
    		    			System.out.println(a1.toString());
    		    			break;
    		    		}
    			  }
    			  
    		  }
    		  else if(userInput==5) {
    			  monthlyRate(accounts, kb, id);
    		  }
    		  
    		  if(userInput!=0) {
    			  System.out.print("Press any key to continue\n\n"
    	  			  		+ "*******************************************\n");
    			  System.in.read();
    		  }
    	  }
    	  
      }
      else {
    	  System.out.println("Invalid Account number");
    	  run(accounts, kb);
      }
      
  }
           
   /*This method displays the menu for the user*/   
  public static void menu()
  {
	  System.out.print("Balance press --> 1\r\n" + 
  	  		"Deposit press --> 2\r\n" + 
  	  		"Withdraw press --> 3\r\n" + 
  	  		"info --> 4.\r\n" + 
  	  		"Monthly interest -->  5\r\n" + 
  	  		"Exit press -->  0\r\n" + 
  	  		"*******************************************\r\n" + 
  	  		"Enter your option: ");
  }
  
  /*this method fills the array by reading account information from a 
  text file, creates the acoount object and stores it in the array*/
  public static void fillArray(Account[] a) throws Exception
  {
	  Scanner kb = new Scanner(new File("data.txt"));
	  
	  int i = 0;
	  while(kb.hasNextLine()) {
		  int id = kb.nextInt();
		  double balance = kb.nextDouble();
		  double rate = kb.nextDouble();
		  Date date = new Date();
		  Account a1 = new Account(id, balance, rate, date);
		  a[i] = a1;
		  i++;
	  }
  }
    
 /*search the array for the given id, if found the balance will be displayed
  if the account with the given id is not in the array display 
  a message that the account does not exist*/
  public static void balance(Account[]   a, Scanner kb, int id)
  {
	  for(int i=0; i<100; ++i) {
		  Account a1 = a[i];
    	  
		  if(a1.getId()==id) {
			  System.out.println("Your balance is: "+a1.getBalance());
			  break;
		  }
	  }
           
  }
  /*ask the user for the amount to be deposited, must call the method getValidInput.
  find the account with the given id, deposit the amount. If the account is not found 
  display the account does not exist. */ 
  public static void deposit(Account[] a, Scanner kb, int id)
  {
	  double dMoney = getInput(kb, "Enter the amount to deposit: ");
	  
	  while(dMoney<0.0) {
		  dMoney = getInput(kb, "Enter the amount to deposit: ");
	  }
	  
	  for(int i=0; i<100; ++i) {
		  Account a1 = a[i];
    	  
		  if(a1.getId()==id) {
			  a1.deposit(dMoney);
			  break;
		  }
	  }
      
  }
  /*loops until it gets a yes/no answer and returns it*/
  public static String getYesNo(Scanner kb)
  {
	  String userInput = kb.next();
	  
	  while(!userInput.equals("no") && !userInput.equals("yes")) {
		  System.out.print("Please enter yes or no: ");
		  userInput = kb.next();
	  }
	  
    return userInput;
  }
  
  /*get a valid input must be a number and positive double value*/
  public static double getInput(Scanner kb, String prompt)
  {
	  System.out.print(prompt);
	  
	  while(!kb.hasNextDouble()) {
		  System.out.print(prompt);
	  	  kb.next();
	  }
	  return kb.nextDouble();
  }
  /*ask the user the amount to withdraw, the amount withdraw cannot be more than the balance
   if there is enought fund , find the account in the array and withdraw money from the account
   if account does not exit display a message*/
   public static void withdraw(Account[] a, Scanner kb, int id)
   {
	   double wMoney = getInput(kb, "Enter the amount to withdraw: ");
		
	   while(wMoney<0.0) {
			  wMoney = getInput(kb, "Enter the amount to withdraw: ");
	   }
	   
	   for(int i=0; i<100; ++i) {
		   Account a1 = a[i];
	    	  
		   if(a1.getId()==id) {
			   a1.withdraw(wMoney);
			   System.out.println("Your new balance is: "+a1.getBalance());
			   break;
		   }
	   }
   }
   /*displays the monthly rate assosiated with the given account, 
   if the account does not exist display a message*/ 
     public static void monthlyRate(Account[] a, Scanner kb, int id)
   {
	   for(int i=0; i<100; ++i) {
			  Account a1 = a[i];
	    	  
			  if(a1.getId()==id) {
				  System.out.printf("Your monthly interest   is: %.2f\n",a1.getMonthlyInterest());
				  break;
			  }
		  }
   }
   /*this method checks the user's id to see if it is valid. Returns true if the id is found, false otherwise*/
    public static boolean validateAccount(Account[] a, int id)
    {
    	for(int i=0; i<100; ++i) {
    		Account a1 = a[i];
      	  
    		if(a1 != null && a1.getId()==id) {
    			return true;
    		}
    	}
    	
      return false;
    }
}


  
 