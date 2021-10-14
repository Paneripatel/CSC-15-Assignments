/****Paneri Patel****/
/****Csc 15****/
class Account {
  //declares instance variables account number, balance and annual rate and date that account was open
  private int id;
  private double balance;
  private static double annualInterestRate;
  private java.util.Date dateCreated;

  /*default constructor only sets the data*/
  public Account(){
	  
  }
  
  /*Constructor to initilaize the instance variables and also date*/
  public Account(int id, double balance, double annualInterestRate, java.util.Date dateCreated) {
	  this.id = id;
	  this.balance = balance;
	  this.annualInterestRate = annualInterestRate;
	  this.dateCreated = dateCreated;
  }

  //provide getter methods for all the instance variables
  public int getId() {
	  return this.id;
  }
  
  public double getBalance() {
	  return this.balance;
  }
  
  public static double getAnnualInterestRate() {
	  return annualInterestRate;
  }
  
  //a method that returns the date on which the account was cretaed 
  public java.util.Date getDateCreated() {
	  return dateCreated;
  }
   
  //setter methods for all the instance variables except data
  public void setId(int id) {
	  this.id = id;
  }

  public void setBalance(double balance) {
	  this.balance = balance;
  }

  public static void setAnnualInterestRate(double annualInterestRate) {
	  Account.annualInterestRate = annualInterestRate;
  }

  public void setDateCreated(java.util.Date dateCreated) {
	  this.dateCreated = dateCreated;
  } 
   
  //a method that returns the monthly interest   
  public double getMonthlyInterest() {
	  return (this.annualInterestRate/12);
  }

   //a method to allow the user to withdraw money.
   public boolean withdraw(double wMoney) {
	   
	   if(wMoney > this.balance) {
		   System.out.println("Can't withdraw "+wMoney+ " from your account");
		   return false;
	   }
	   
	   this.balance = this.balance - wMoney;
	   System.out.println(wMoney + " has been withdrawn from your account");
	   return true;
   }
   
   
   /*a method to deposit money to the account*/ 
   public void deposit(double dMoney) {
	   
	   this.balance = this.balance + dMoney;
	   
   }

  /*toString method to create  a string containing info about a given account.*/
   public String toString() {
	   String s = "Your balance is : " +
	   			  "\nID: " + this.id +
	   		      "\nBalance: " + this.balance +
	   		      "\nRate: " + this.annualInterestRate;
	   
	   return s;
   }
  }
