//Lisakhanya Cuba
//CBXLIS001
//14 April 2022
import java.util.*;
import java.io.*;
/**The BinaryTreeSearch/BinarySearchTree which I use to store all the 
Functions needed to start a Binaryree and build a BinaryTree and prepare
for use.*/
public class BinarySearchTree extends BinaryTree
{
 public BinarySearchTree()
 {
  super();
 }
 /**This function is a used for inserting data in a binaryTree.*/
   public void insert ( Account d, BinaryTreeNode node )
  {
   if (d.getName().compareTo (node.data.getName()) <=0)
   {
    if (node.left == null )
     node.left = new BinaryTreeNode (d , null , null ) ;
     else
      insert(d,node.left);
   }
   else
   {
    if (node.right ==null)
      node.right = new BinaryTreeNode (d, null ,null);
    else
    insert(d, node.right);
   }
  }
  /**This function is used to find a specific account using a name of data type string
  as a parameter.*/
    public BinaryTreeNode find (String d ,BinaryTreeNode node)
  {
    int cmp = d.compareTo(node.data.getName());
    if (cmp ==0)
      return node;
    else if (cmp<0) 
     {
      return (node.left ==null) ? null : find (d, node.left);
      }
    else
    {
     return (node.right == null ) ? null : find (d, node.right);   
     }
  }
 /**The visit function is a void method used to display data in a binarytree.*/ 
  public void visit (BinaryTreeNode node )
  {
  System.out.println(node.data.getName());
  }
/**A void Method to lis all data in the binarytree in a alphabetical order.*/
  public void inOrder()
  {
   inOrder(root);
  }
/**The method that is recursive to make it possible to call the inOrder method 
for functionality.*/
  public void inOrder (BinaryTreeNode node )
  {
   if (node!=null)
   {
    inOrder (node.getLeft());
    visit (node);
    inOrder (node.getRight());
   }
  }
  /**The skeleton recursive method that is used for deleting data in a binarytree.*/
  public BinaryTreeNode delete ( String d, BinaryTreeNode node)
  {
   if(node ==null) return null ;
   int cmp = d.compareTo (node.data.getName());
   if (cmp<0)
    node.left = delete (d, node.left);
   else if (cmp>0)
      node.left = delete (d,node.right);
   else if (node.left != null && node.right != null)
   {
    node.data = findMin (node.right).data;
    node.right = removeMin (node.right);
   }
   else
    if (node.left != null)
     node = node.left;
    else
    node = node.right;
 return node ;
   }
  /** Method to find minimum between nodes on either left or right.*/
 public BinaryTreeNode findMin (BinaryTreeNode node)
  { 
   if (node!=null)
    while (node.left != null)
      node = node.left ;
   return node ;
  }
 /**Method used to to remove node if is minimum.*/
public BinaryTreeNode removeMin (BinaryTreeNode node)
{
 if (node ==null)
   return null ;
 else if (node.left!= null)
  {
    node.left = removeMin (node.left);
    return node ;
  }
  else 
  return node.right ;
}
 public void delete ( String d )
  {
   root =  delete (d, root);
  }
  /**The called insert function used so that it can make use of the 
  insert skeleton method to insert data in a binarytree.*/
 public  void insert ( Account d)
 {
  if (root ==null)
    root = new BinaryTreeNode (d , null , null);
  else 
  insert (d, root);
 }
 public BinaryTreeNode find ( String d )
 {
   if (root==null)
    return null ;
   else 
    return find (d,root); 
 }
 
 /**The function in case 3 which is to create an account for a particular user.*/
 public void CreateAccount(String accName , String Description)
{
  Account t  = new Account( accName , Description);
  this.insert(t);
  System.out.println("============================");
  System.out.println("Account created successfully");
  System.out.println("=============================");
}

 /**The function in case 1 which is to find the description of
 the user account.*/
  public String FindDescription (String accName)
  {
    BinaryTreeNode found_node = this.find(accName);
          if (found_node ==null )
          
             return "User cannot be found you can create the user";
           else{
             return "The profile description is: "+found_node.data.getDescription();
             }
   }
 /**The function in case 2 which is to list all Accounts in the BinaryTree.*/
  
public void ListAccounts()
{
 this.inOrder();
}
/**The function in case 4 which is deleting an account from the BinaryTree.*/

public void DeleteAccount(String accName)
{
 if (this.find(accName)!=null)
 {
  this.delete(accName);
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");
   System.out.println("Account of "+accName+" "+"is deleted successfully");
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");

 }
 else{
  System.out.println("---------------------------------------");
  System.out.println("---------------------------------------");
  System.out.println("Account not found");
  System.out.println("---------------------------------------");
  System.out.println("---------------------------------------");
  }
} 
 /**The function in case 8 which additional to my program which is used
for deleting a video in case a user does no longer wants it to be displayed 
to the world.*/
 public void DeleteVideo(String accName , String videoDescription)
{
 boolean bfound = false ;
   if (this.find(accName)!=null)
   {
    ArrayList<String> vidDis = this.find(accName).data.getaccVideoDescription();
    if (vidDis.size()!=0)
    {
    for (int I= 0 ; I<vidDis.size() ; I++)
    {
      if (videoDescription.compareTo(vidDis.get(I))==0)
      {
        bfound = true ;
        vidDis.remove(I);
        this.find(accName).data.getaccVideoName().remove(I);
        this.find(accName).data.getaccLikes().remove(I);
      }
    }
     if (bfound==false)
  {
   System.out.println("========================================");
   System.out.println("There was no video found with such description");
   System.out.println("========================================");
  }
   else
   {
    System.out.println("---------------------------------------");
    System.out.println("---------------------------------------");
    System.out.println("Video deleted!!!");
    System.out.println("---------------------------------------");
    System.out.println("---------------------------------------");
    }
    }
    else
    {
     System.out.println("========================================");
     System.out.println("Account has no videos");
     System.out.println("=========================================");
    }
   }
   else
   {
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");
    System.out.println("Account not found");
    System.out.println("---------------------------------------");
    System.out.println("---------------------------------------");

   }
 }
 /**The function in case 9 which additional to my program which is used
for liking a video in case there is a user who enjoyed a specific video.*/

 public void LikeVideo(String accName , String videoDescription )
{
 boolean bfound = false ;
  if (this.find(accName)!=null)
   {
    ArrayList<String> vidDis = this.find(accName).data.getaccVideoDescription();
    if (vidDis.size()!=0)
    {
    for (int I= 0 ; I<vidDis.size() ; I++)
    {
      if (videoDescription.compareTo(vidDis.get(I))==0)
      {
        bfound = true ;
        int like_it = this.find(accName).data.getaccLikes().get(I)+1;
        this.find(accName).data.getaccLikes().remove(I);
        this.find(accName).data.getaccLikes().add(I,like_it);
      }
    }
    if (bfound==false)
{
 System.out.println("==========================================");
 System.out.println("There was no video found with such description");
 System.out.println("===========================================");
}
else{
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");
    System.out.println("Video Liked!!!");
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");
   }
   }
   else
   {
    System.out.println("========================================");
    System.out.println("Account has no videos");
    System.out.println("=========================================");
   }
   }
   else
   {
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");
    System.out.println("Account not found");
   System.out.println("---------------------------------------");
   System.out.println("---------------------------------------");

   }
}
/**This is function that is displayed in case number 6 for adding a post to the Account 
of a specified Name.*/

public void AddPost(String accName , String video_description)
{
             if (this.find(accName)!=null)  
           {

           ArrayList<String> acVideoName = this.find(accName).data.accVideoName;
           if ( acVideoName.size()!=0)
           {
           String video = acVideoName.get(acVideoName.size()-1);
           int vidnum = Integer.parseInt(video.substring(video.indexOf("o")+1,video.indexOf(".")));
           vidnum = vidnum +1 ;
           String vidName = "video"+String.valueOf(vidnum)+".mpg";
           String line = accName+" "+vidName+" "+"0"+" "+video_description;
           this.find(accName).data.postVideo(line);
           System.out.println("===================================");
           System.out.println("Post added successfully");
           System.out.println("===================================");
           }
           else
           {
            String line = accName+" "+"video1.mpg"+" "+"0"+" "+video_description;
            this.find(accName).data.postVideo(line);
            System.out.println("===================================");
           System.out.println("Post added successfully");
           System.out.println("===================================");

           }
          }
          else
         {
         System.out.println("---------------------------------------");
         System.out.println("---------------------------------------");
          System.out.println("The account is not found");
          System.out.println("---------------------------------------");
          System.out.println("---------------------------------------");

      }          
}
 /**The function number 7 which is in case 7 This method is used to 
read at execute the dataset textfile.*/
public void Load()
{
            try {
           File myObj = new File("src/dataset.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        int pos = data.indexOf(" ");
        String scommand = data.substring(0,pos);
        String line = data.substring(pos+1,data.length()); 
         String accName;
        if (scommand.compareTo("Create") ==0)
        {
             pos = line.indexOf(" ");
             accName = line.substring(0,pos);
             String description = line.substring(pos+1, line.length());
               Account t  = new Account( accName , description);

             this.insert(t);
        }
        else if (scommand.compareTo("Add")==0)
        {
         pos = line.indexOf(" ");
                accName = line.substring(0,pos);
                  BinaryTreeNode found_node = this.find(accName);
     
          found_node.data.postVideo(line); 
        
        }
       
      }
      
            myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   System.out.println("===================================");
   System.out.println("File loaded successfully");
   System.out.println("===================================");
}
/**This is the function number 5 ,which is case 5 It is used to display all
the post of a specific account.*/
public void DisplayPosts(String Name)
{
 if (this.find(Name) != null)
 {
  ArrayList<String> all_list = this.find(Name).data.getaccVideoName();
  if (all_list.size()!=0)
  {
  for (int I = all_list.size()-1 ; I>-1 ; I-- )
  {
    System.out.println("Title: "+this.find(Name).data.getaccVideoDescription().get(I));
    System.out.println("Video: "+this.find(Name).data.getaccVideoName().get(I)); 
    System.out.println("Number of likes: "+this.find(Name).data.getaccLikes().get(I)); 
  }
  }
  else
  {
  System.out.println("---------------------------------------");
  System.out.println("---------------------------------------");
  System.out.println("This Account had no posts");  
  System.out.println("---------------------------------------");
  System.out.println("---------------------------------------");
 }
 }
 else
 {
  System.out.println("---------------------------------------");
  System.out.println("---------------------------------------");
  System.out.println("Account not found");
  System.out.println("---------------------------------------");
  System.out.println("---------------------------------------");

 }
} 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
