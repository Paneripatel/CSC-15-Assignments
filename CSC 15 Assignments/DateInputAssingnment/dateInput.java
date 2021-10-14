//****Paneri Patel****//
//****Csc 15****//
//****Hw4****//
//****dateInput****//

public class dateInput
{

   //Printing out the output lines//
   public static void PrintDirections()
   {
      System.out.println("This program will ask you for a month, day and year");
      System.out.println("and will print the corresponding date in two standard date formats.");
      System.out.println("How many times do you want to run the code: 3");
      System.out.println("You may enter the month as: a numeric value (1....12) or as an unabbreviated");
      System.out.println("month name (January or February etc...");
   }
   //Method to print month through numbers assisgned//
   public static String getMonthString(int month)
   {
      if (month == 1)
      {
         return "January";
      }
      else if (month == 2)
      {
         return "Feburary";
      }
      else if (month == 3)
      {
         return "March";
      }
      else if (month == 4)
      {
         return "April";
      }
      else if (month == 5)
      {
         return "May";
      }
      else if (month == 6)
      {
         return "June";
      }
      else if (month == 7)
      {
         return "July";
      }
      else if (month == 8)
      {
         return "August";
      }
      else if (month == 9)
      {
         return "September";
      }
      else if (month == 10)
      {
         return "October";
      }
      else if (month == 11)
      {
         return "November";
      }
      else if (month == 12)
      {
         return "December";
      }
      return "Unknow Month";
   }
   
   //Method to print month//
   public static int getMonthNumber(String name)
   {
      int month = 0;
      if(name.equalsIgnoreCase ("January"))
      {
         month = 1;
      }
      else if(name.equalsIgnoreCase ("Feburary"))
      {
         month = 2;
      }
      else if(name.equalsIgnoreCase ("March"))
      {
         month = 3;
      }
      else if(name.equalsIgnoreCase ("April"))
      {
         month = 4;
      }
      else if(name.equalsIgnoreCase ("May"))
      {
         month = 5;
      }
      else if(name.equalsIgnoreCase ("June"))
      {
         month = 6;
      }
      else if(name.equalsIgnoreCase ("July"))
      {
         month = 7;
      }
      else if(name.equalsIgnoreCase ("August"))
      {
         month = 8;
      }
      else if(name.equalsIgnoreCase ("September"))
      {
         month = 9;
      }
      else if(name.equalsIgnoreCase ("October"))
      {
         month = 10;
      }
      else if(name.equalsIgnoreCase ("November"))
      {
         month = 11;
      }
      else if(name.equalsIgnoreCase ("December"))
      {
         month = 12;
      }
      return month;
   }
   //Printing holidays month wise//
   public static String getHoliday(int month, int day)
   {
      String Holidays = "";
      int months = 0;
      String days = "";
      switch(month)
      {
      //Month 1 holidays//
         case 1: months = 1;
            switch(day)
            { 
               case 1:
                  Holidays = "New Year's Day";
                  break;
                  
               case 2:
                  Holidays = "Martin Luther King Jr. Day";
                  break;
            }
            break;
          
          //Month 2 holidays//     
         case 2:
            switch(day)
            {
               case 1:
                  Holidays = "Ground Hog Day";
                  break;
                  
               case 12:
                  Holidays = "Abraham Lincoln's Day";
                  break;
                  
               case 14:
                  Holidays = "St. Valentine's Day";
                  break;
                  
               case 17:
                  Holidays = "George Washington's Birthday";
                  break;
                  
               
            }
            break;
         
         //Month 3 holidays//        
         case 3:
            switch(day)
            {
               case 17:
                  Holidays = "St. Patrick's Day";
                  break;   
            }
            break;
         
         //Month 4 holidays//   
         case 4:
            switch(day)
            {
               case 4:
                  Holidays = "April Fool's Day";
                  break;
                  
               case 22:
                  Holidays = "Earth Day";
                  break;
                  
               case 24:
                  Holidays = "Arbor Day";
                  break;

            }
            break;
         
         //Month 5 holidays//   
         case 5:
            switch(day)
            {
               case 1:
                  Holidays = "May Day";
                  break;
               
               case 5:
                  Holidays = "Cinco de Mayo";
                  break;
            }
            break;
         
         //Month 6 holidays//
         case 6:
            switch(day)
            {
               case 4:
                  Holidays = "Grandma's Birthday";
                  break;
            }
            break;
         
         //Month 7 holidays//   
         case 7:
            switch(day)
            {
               case 4:
                  Holidays = "Independence Day";
                  break;
            }
            break;
         
         //Month 8 holidays//
         case 8:
            switch(day)
            {
               case 4:
                  Holidays = "International Friendship Day";
                  break;
            }
            break;
            
         
         //Month 10 holidays//
         case 10:
            switch(day)
            {
               case 8:
                  Holidays = "Paneri's Birthday";
                  break;
                  
               case 14:
                  Holidays = "Columbus Day";
                  break;
                  
               case 31:
                  Holidays = "Halloween";
                  break;
            }
            break;
         
         //Month 11 holidays//   
         case 11:
            switch(day)
            {
               case 11:
                  Holidays = "Vereran's Day";
                  break;
            }
            break;

         //Month 12 holidays//
         case 12:
            switch(day)
            {
               case 25:
                  Holidays = "Christmas";
                  break;
               
               case 31:
                  Holidays = "New Year's Eve";
                  break;
            }
            break;
                 
      }
      return Holidays;
   }
   
   //Method to print Easter holiday//
   public static boolean isEaster(int month, int day, int year){
      
      int goldenNumber = (year % 19) + 1;
      int a = (24 + 19*(goldenNumber - 1)) % 30;
      int b = a - a/28;
      int c = (year + year/4 + b - 13) % 7;
      int d = b - c;
      int easterMonth = 3 + (d + 40)/44;
      int easterDay = d + 28 - 31*(easterMonth/4);
      
      if(easterMonth == month && easterDay == day){
         return true;
      }
      
      return false;
      
   }
}
          
          
           
