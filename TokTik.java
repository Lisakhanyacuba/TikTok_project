//Lisakhanya Cuba
//CBXLIS001
//14 April 2022
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.*;

/** The main class of my programme which makes use of all the class
Directly and indirectly. It is the main class executing every 
function listed in the Assingment activity and extra functionalities*/ 
public class TokTik 
{
  
 /**The main class that is used to execute all functions.*/
 public static void main (String[] args)
  {
  BinarySearchTree b = new BinarySearchTree();
 int selection_number = 0;
 Scanner input = new Scanner (System.in);
 Scanner input_int = new Scanner (System.in);
 String accName ; 
  label : while (true)
  {
  System.out.println("Choose an action from the menu:");
  System.out.println("1. Find the profile description for a given account:");
  System.out.println("2. List all accounts:");
  System.out.println("3. Create an account:");
  System.out.println("4. Delete an account:"); 
  System.out.println("5. Display all posts for a single account:"); 
  System.out.println("6. Add a new post for an account:"); 
  System.out.println("7. Load a file of actions from disk and process this:"); 
  System.out.println("8. Delete a video of your posts:");
  System.out.println("9. Like a specific video:");
  System.out.println("10. Quit:"); 
  System.out.print("Enter your choice: ");
  String selection = input_int.nextLine();
  if (selection != null)
   {
     try
     {
       selection_number = Integer.parseInt(selection);
       
   switch (selection_number)
   {
     case 1:
         {
          if (b.root !=null)
          {
          System.out.print("Enter the account name: ");
          accName = input.nextLine();
          System.out.println();
          System.out.println("---------------------------------------");
          System.out.println("---------------------------------------");
          System.out.println(b.FindDescription(accName));
          System.out.println("---------------------------------------");
          System.out.println("---------------------------------------");
          System.out.println();
          }
          else
          {
           System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();
          }
          break;
         }
     case 2:
         {
         if (b.root !=null)
         {
          System.out.println("Account Name");
          System.out.println("=============");

          b.ListAccounts();
          System.out.println();
          }
          else
          {
          System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();

          }
          break ;
         }
     case 3:
         { 
          System.out.print("Enter the account name: ");
          accName = input.nextLine();
          System.out.print("Enter the Account Description: ");
          String Description = input.nextLine();
          System.out.println();
          b.CreateAccount(accName , Description);
          System.out.println();
          break ;
         }
     case 4:
         {
         if (b.root!=null)
         {
         System.out.print("Enter the account name to be deleted: ");
          accName = input.nextLine();
          System.out.println();
          b.DeleteAccount(accName);
          System.out.println();
          }
          else
          {
           System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();
          }
          break ;
         }
     case 5:
         { 
          if (b.root!=null)
          {
           System.out.print("Enter the name of the account user: ");
            accName = input.nextLine();
            System.out.println();
            b.DisplayPosts(accName);                   
   
           System.out.println(); 
          }
          else
          {
          System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();

          }    
          break ;
         }
     case 6:
         {
          if (b.root!=null)
          {
          System.out.print("Enter the name of the account: ");
          accName = input.nextLine();
          System.out.print("Enter the Description of the video: ");
          String Descrip = input.nextLine();
          System.out.println();
          b.AddPost(accName , Descrip);
          System.out.println();
          }
          else
          {
           System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();

          }
             break ;
           }
     case 7:
         {
          b.Load();
          System.out.println();
          break ;
         }
    case 8:
          {
          if (b.root!=null)
          {
           System.out.print("Enter the account name: ");
           accName = input.nextLine();
           System.out.print("Enter the video Description: ");
           String vidDescription = input.nextLine();
           System.out.println();
           b.DeleteVideo(accName , vidDescription);
           System.out.println();
           }
           else
           {
            System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();

           }
           break ;
          }
    case 9:
          {
          if (b.root!=null)
          {
           System.out.print("Enter the account name: ");
           accName = input.nextLine();
           System.out.print("Enter the video Description: ");
           String vidDescription = input.nextLine();
           System.out.println();
           b.LikeVideo(accName , vidDescription);
           System.out.println();
           }
           else
           {
            System.out.println("============================================");
           System.out.println("Choose option 7 to first load the file");
           System.out.println("============================================");
           System.out.println();

           }
           break ;
          }
     case 10:
         {
          System.out.println("---------------------------------------");
          System.out.println("---------------------------------------");
          System.out.println("Goodbye!");
          System.out.println("---------------------------------------");
          System.out.println("---------------------------------------");

          System.out.println();
          break label ;
         }
         default :
         {
          System.out.println("------------------------------------------------------");
          System.out.println("Please enter the number in range 1 - 10");
          System.out.println("------------------------------------------------------");

         }

   } 
    } catch (NumberFormatException nfe)
     {
       System.out.println();
       System.out.println("------------------------------------------------------");
       System.out.println("That is not a number please enter a number: from 1 to 10");
       System.out.println("-------------------------------------------------------");
       System.out.println();
     }
     
   }
 
   }    
  }
  
 }