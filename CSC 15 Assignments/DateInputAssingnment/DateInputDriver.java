//****Paneri Patel****//
//****Csc 15****//
//****Hw4****//
//****dateInput****//

import java.util.Scanner;
public class DateInputDriver
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);
      int MonthNum = -1;
      int year;
      int day;
      String holiday;
      String monthSt = "";
    
      dateInput.PrintDirections();
      
      System.out.println();
         
      for(int j = 1; j <= 50; j++) {
         System.out.print("*");
      }
      System.out.println();
      
      System.out.print("How many times do you want to use this software?: ");
      int count = kbd.nextInt();
      for(int i = 1; i <= count; i++)
      {
         System.out.println();
         
         System.out.print("Enter the month: ");
         if(kbd.hasNextInt()){
            MonthNum = kbd.nextInt();
            monthSt = dateInput.getMonthString(MonthNum);
         }
         else{
            monthSt = kbd.next();
            MonthNum = dateInput.getMonthNumber(monthSt);
         }
         
         System.out.print("Enter the day: ");
         day = kbd.nextInt();
      
         System.out.print("Enter the year: ");
         year = kbd.nextInt();
      
         holiday = dateInput.getHoliday(MonthNum, day);
         
         if(dateInput.isEaster(MonthNum, day, year) == true){
            holiday = "Easter and " + holiday;
         }
         
         System.out.println("\n\nThe date is: "
             + MonthNum + '/' + day + '/' + year + "\t"
             + monthSt + ' ' + day + ", " + year + "\t"
             + holiday);
             
         System.out.println();
             
         for(int j = 1; j <= 50; j++) {
            System.out.print("*");
         }
         
         System.out.println();
      }
      
      
      
      System.out.println("\nGoodBye !!");
   }
}
