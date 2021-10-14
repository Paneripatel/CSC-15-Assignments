import java.util.Scanner;
public class PrintCalenderShell
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      //prompts the user to enter the year
      boolean repeat = true;
      while (repeat)//it will repeat as long as the user wants to
      {
         int year =0;
      	 // this loop will work as long as the user is entering an invalid year less than 1800
         while(year <1800) 
         { 
            System.out.println("Enter a valid year after 1800");
             //this loop will work as long as the user is entering an input other than integer        
            while (!kb.hasNextInt())
            {
               System.out.println("Enter a valid year after 1800:");
               kb.next();
            }
            year = kb.nextInt();
         }
          
          //printing the calender for each month of the year
         for (int i =1; i<=12; i++)
         {
            printMonth(year, i);
         } 
          
         System.out.println("Do you have another year to print the calender:yes/no");
         String answer = kb.next();
         if (answer.equalsIgnoreCase("no"))
            repeat = false;
      }   
     
   }
   //this method prints the body of the calender for the given month
   public static void printMonth(int year, int month)
   {
      //calling the method printTitle with the values year and month
   	printMonthTitle(year, month);
      
      //calling the method printMonthBody with the values year and month
      printMonthBody(year, month);
      
     
   }
   //this method prints the title of the days in each week(sunday Mon Tues Wed Thur Fir Sat)
   public static void printMonthTitle(int year, int month)
   {
      //outputs the title for each month of the year
      String monthTitle = getMonthName(month);
      
      System.out.println("        "+monthTitle+" "+year);
      System.out.println("----------------------------");
      System.out.println("Sun Mon Tue Wed Thu Fri Sat");
      
   }
	//this method outputs the calender for each month of the year
   public static void printMonthBody(int year, int month)
   {
      //calling the method getStartDay to get the start day for each month of the year
      int startDay = getStartDay(year, month);
      
      System.out.print(startDay);
      
      //calling the method print to print the calender for the month and pass the first day of the month as the parameter 
      print(startDay, year, month);
   }
   public static void print(int startDay, int year, int month)
   {
     // calling the method getNumberOfdaysInMonth to finde out the number of the days in the month 
     int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
     
     int passedDays = 1;
     
     //using a for loop to print spaces up to the start day for each month
     for(int i=0; i<startDay; ++i){
         System.out.print("    ");
         passedDays++;
     }
     
     //using another for loop to print the rest of the days in the calender
     for(int i=1; i<=numberOfDaysInMonth; ++i){
         System.out.printf("%3s ",i);
         if(passedDays == 7){
            System.out.print("\n");
            passedDays = 0;
         }
         passedDays++;
     }
     
     //if the month is November calculating the thanksgiving day and output
     if(month==11){
         int thanks = thanks(startDay);
         String lastLetters = "";
         
         if(thanks%10==1){
            lastLetters = "st";
         }
         else if(thanks%10==2){
            lastLetters = "nd";
         }
         else if(thanks%10==3){
            lastLetters = "rd";
         }
         else {
            lastLetters = "th";
         }
         
         System.out.println("\n**Thanks giving day is on the "+thanks+lastLetters);
     }
     
     System.out.println("\n\n");
   }
	
	//this method calculates the date for thanksgiving
	public static int thanks(int startDay)
   {  
      int thanks = ((11-startDay)%7 + 22);
      return thanks;
   }					 								  		  		  			  		  
	//method from the previous homework    	    
   public static String getMonthName(int month)
   {
      String monthTitle = "";
      
      //a sitch statment
      switch(month){
         case 1: monthTitle = "January";
            break;
         case 2: monthTitle = "Febuary";
            break;
         case 3: monthTitle = "March";
            break;
         case 4: monthTitle = "April";
            break;
         case 5: monthTitle = "May";
            break;
         case 6: monthTitle = "June";
            break;
         case 7: monthTitle = "July";
            break;
         case 8: monthTitle = "August";
            break;
         case 9: monthTitle = "September";
            break;
         case 10: monthTitle = "October";
            break;
         case 11: monthTitle = "November";
            break;
         case 12: monthTitle = "December";
            break;
      }

      return monthTitle;       
   }
	
	//this method returns the start day of the month
   public static int getStartDay(int year, int month)
   {
      //calling the method getTotalNumberOfDays and storing it in a variable called start
   	int start = getTotalNumberOfDays(year, month);
      
      //adding 3 to the variable start
      start = start + 3;
      
      return start % 7;   
     
   }
	//returns the total number of the days up to the given month in the given year 
   public static int getTotalNumberOfDays(int year, int month)
   { 
      int totalNumberOfDays = 365;
      
      
      //Calculating number of days from year 1800 to year-1
      for(int i=1801; i<year; ++i){
         boolean checkLeapYear = isLeapYear(i);
         if(checkLeapYear){
            totalNumberOfDays = totalNumberOfDays + 366;
         }
         else {
            totalNumberOfDays = totalNumberOfDays + 365;
         }
      }
      
      //Calculating number of months from January to month-1 for year "year"
      for(int j=1; j<month; ++j){
         totalNumberOfDays = totalNumberOfDays + getNumberOfDaysInMonth(year, j);
      }
      
      return totalNumberOfDays;   
   }
   
	//using this method from the last HomeWork
   public static int getNumberOfDaysInMonth(int year, int month)
   {
     
      int numberOfDays=0;
     
      switch (month) {
         case 1: numberOfDays = 31;
            break;
         case 2: numberOfDays = getFebruaryDays(year);
            break;
         case 3: numberOfDays = 31;
            break;
         case 4: numberOfDays = 30;
            break;
         case 5: numberOfDays = 31;
            break;
         case 6: numberOfDays = 30;
            break;
         case 7: numberOfDays = 31;
            break;
         case 8: numberOfDays = 31;
            break;
         case 9: numberOfDays = 30;
            break;
         case 10: numberOfDays = 31;
            break;
         case 11: numberOfDays = 30;
            break;
         case 12: numberOfDays = 31;
            break;
      }
      return numberOfDays;
   }
   
   //Method to print February month's days
   public static int getFebruaryDays(int year) {
      int n = 28;
      if(isLeapYear(year)){
         n = n + 1;
      }
      return n;
   }
   
   //Method to print if a year is a Leap Year or not
   public static boolean isLeapYear(int year) 
   {
             
      if(year%4==0 && year%100!=0){
         return true;
      }
      
      else if(year%400==0){
         return true;
      }
      
      return false;    
   }      
   
}