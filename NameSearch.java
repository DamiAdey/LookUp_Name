// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

/*
Write a program that reads the contents of the two files 
(GirlNames.txt and BoyNames.txt) into two separate arrays using method. 
Then you program should do the following*/

import java.util.Scanner;  // Needed for the Scanner class.
import java.io.*;         // Needed for the File class.

public class NameSearch 
{
   public static void main(String[] args) throws IOException // Executes methods.
   {
      String[] girlsNames, boysNames;
      String input;
      
      girlsNames = new String[200];
      boysNames = new String[200];
   
      girlsNamesFileRead(girlsNames);
      boysNamesFileRead(boysNames);
      System.out.println();
      
      sortArrayGirlsNames(girlsNames);
      sortArrayBoysNames(boysNames);
      alphabeticGirlsNames(girlsNames);
      alphabeticBoysNames(boysNames);
      
      Scanner keyboard = new Scanner(System.in); // Create a Scanner object for keyboard input.
         
      do   
      {
         searchGirlsArray(girlsNames);
         searchBoysArray(boysNames);
         matchingStringInGirlsNames(girlsNames);
         matchingStringInBoysNames(boysNames);
         System.out.print("\nWould you like to do the search sequence? (yes/no) ");
         input = keyboard.nextLine();
      }
           
            while (input.equals("yes"));   
   
   }
   
   
   // Method reads file for girl's names into first array.
   private static void girlsNamesFileRead(String[] girlsNames) throws IOException 
   {
      int index = 0;
      Scanner keyboard = new Scanner(System.in);     // Create a Scanner object for keyboard input.
   
      // To get the filename.
      System.out.print("Enter the filename for Girls names: ");
      String filename = keyboard.nextLine();
   
      // To open the file.
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
   
      while (inputFile.hasNext())
      {
         // To read the line.
         girlsNames[index] = inputFile.nextLine();
         index++;
      }
   
      // To close the file.
      inputFile.close();
   }  
   
   
   // Method reads file for boy's names into another array.
   private static void boysNamesFileRead(String[] boysNames) throws IOException
   {
      int index = 0;
      Scanner keyboard = new Scanner(System.in);       // Create a Scanner object for keyboard input.
   
      // To get the Boys filename.
      System.out.print("Enter the filename Boys Names: ");
      String filename = keyboard.nextLine();
   
      // To open the file.
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
   
      while (inputFile.hasNext())
      {
         // To read the line.
         boysNames[index] = inputFile.nextLine();
         index++;
      }
   
      // Close the file.
      inputFile.close();
   }
   
   
   // Method to sort the array for girls names.
   private static void sortArrayGirlsNames(String[] girlsNames)  
   {
      String temp; 
      for (int i = 0; i < girlsNames.length-1; i++)
      {
         for (int k = 0; k < girlsNames.length-1-i; k++)
         {
            if (girlsNames[k].compareTo(girlsNames[k+1]) > 0)
            {
               temp = girlsNames[k];
               girlsNames[k] = girlsNames[k+1];
               girlsNames[k+1] = temp;
            }
         }
      }
   }
   
   
   // Method to sort the array for boys names.
   private static void sortArrayBoysNames(String[] boysNames)
   {
      String temp; 
      for (int i = 0; i < boysNames.length-1; i++)
      {
         for (int k = 0; k < boysNames.length-1-i; k++)
         {
            if (boysNames[k].compareTo(boysNames[k+1]) > 0)
            {
               temp = boysNames[k];
               boysNames[k] = boysNames[k+1];
               boysNames[k+1] = temp;
            }
         }
      }
   }
   
   
   // Method displays the girl's names in alphabetical order.
   private static void alphabeticGirlsNames(String[] girlsNames) 
   {
      System.out.println();
      System.out.println("\nNames of girls in alphabetic order: ");
      
      for (int i = 0; i<girlsNames.length; i++)
      {
         System.out.println(girlsNames[i]);
      }
   }


   // Method display the boy's names in alphabetical order.
   private static void alphabeticBoysNames(String[] boysNames)
   {
      System.out.println();
      System.out.println ("\nNames of boys in alphabetic order: ");
      for (int i = 0; i<boysNames.length; i++)
      {
         System.out.println(boysNames[i]);
      }
   }

   
   // This method searches for girl's name entered by user.
   private static void searchGirlsArray(String[] girlsNames) 
   {
      String findGirl;
      boolean isFound =  false; 
         
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      System.out.println();
   
      System.out.print("Please enter a Girls name you would like to search for: ");
      findGirl = keyboard.nextLine();
      
      for (int i = 0; i < girlsNames.length; i++)
      {
         if (findGirl.equals(girlsNames[i]))
         {
            isFound = true; 
            System.out.println("Name found. " + findGirl + " is a name in the girlName file.");
         }      
      }
      
      if (isFound == false)
         System.out.println("Name not found. " + findGirl + " is not a name in the girlName file.");
   
   }


   // This method searches for boy's name entered by user.
   private static void searchBoysArray(String[] boysNames) 
   {
      String findBoy;
      boolean isFound = false ;
         
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print("\nPlease enter a Boys name you would like to search for: ");
      findBoy = keyboard.nextLine();
      
      for (int i = 0; i < boysNames.length; i++)
      {
         if (findBoy.equals(boysNames[i]))
         {
            isFound = true; 
            System.out.println("Name found. " + findBoy + " is a name in the boyName file.");
         }
      }
      
      if (isFound == false)
         System.out.println("Name not found. " + findBoy + " is not a name in the boyName file.");
   
   }
   
   
   // CHALLENGE QUESTIONS:
   
   // Method searches array for matching girl's name string.     
   private static void matchingStringInGirlsNames(String[] girlsNames) 
   {
      String matchStringGirl;
         
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print("\nPlease enter a string to match for girls name: ");
      matchStringGirl = keyboard.nextLine();
      
      for (int i = 0; i < girlsNames.length; i++)
      {
         int index = 0;
         for (int k = 0; k < girlsNames[i].length(); k++)
         {
            if (girlsNames[i].charAt(k) == matchStringGirl.charAt(index))
            {
               index++;
            }
         
            if (index == matchStringGirl.length())
            {
               System.out.println(girlsNames[i]);
               break;
            }
         }
      }
   
   }
   
   
   // Method searches array for matching boy string.
   private static void matchingStringInBoysNames(String[] boysNames) 
   {
      String matchStringBoy;
   
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print("\nPlease enter a string to match for boys name: ");
      matchStringBoy = keyboard.nextLine();
      
      for (int i = 0; i < boysNames.length; i++)
      {
         int index = 0;
         for (int k = 0; k < boysNames[i].length(); k++)
         {
            if (boysNames[i].charAt(k) == matchStringBoy.charAt(index))
            {
               index++;
            }
               
                  
            if (index == matchStringBoy.length())
            {
               System.out.println(boysNames[i]);
               break;
            }
         }
      }
   }
   
}