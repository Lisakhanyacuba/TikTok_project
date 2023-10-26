//Lisakhanya Cuba
//CBXLIS001
//14 April 2022
import java.util.ArrayList ;
/**This class acts as a datatype of the binaryTree. I have decided to make the datatype because in
the binarytree there are different kinds of data stored which need to be identified seperately and 
that can be done by the use of the attributes. This class prepares everything that will be accessed by 
the user by the use of calling the specific methods.*/
public class Account 
{
 
 public String accName ;
 public String accDescription ;
 public ArrayList<String> accVideoDescription = new ArrayList<String>();
 public ArrayList<Integer> accLikes = new ArrayList<Integer>();
 public ArrayList<String> accVideoName= new ArrayList<String>();
 public Account (String acName , String acDescription)
 {
   accName = acName ;
   accDescription = acDescription;
 } 

 /**The accessor method of name.*/
 public String getName()
 {
  return accName ;
 }
 /**The accessor method of Description.*/
 public String getDescription()
 {
  return accDescription ;
 }
 /**An accessor method of type ArrayList which gets the Lists of Videos 
 posted by a user.*/
 public ArrayList<String> getaccVideoName()
 {
   return accVideoName ;
 }
 /** The mutator method that posts the video into the account of the user.*/
  public void postVideo(String video)
 {   
         int pos =  video.indexOf(" ");
         String nameVideo_description = video.substring(pos+1 , video.length());
         pos = nameVideo_description.indexOf(" ");
         String video_1 = nameVideo_description.substring(0,pos);
         accVideoName.add(video_1);// = accVideoName + +"#"; 
         String likes_Description = nameVideo_description.substring(pos+1, nameVideo_description.length());
         pos = likes_Description.indexOf(" ");
         int likes =Integer.parseInt(likes_Description.substring(0,pos));
         accLikes.add(likes);// = accLikes+likes+"#" ;
         String Description_1 = likes_Description.substring(pos+1,likes_Description.length());
         accVideoDescription.add(Description_1);// =  accVideoDescription+Description_1+"#";
         
  }
  /**An accessor method of type ArrayList which gets the Lists of VideoDescription
 posted by a user.*/

 public ArrayList<String> getaccVideoDescription()
 {
   return accVideoDescription;
 }
 /**An accessor method of type ArrayList which gets the Lists of Videos Likes 
 posted by a user.*/
 public ArrayList<Integer> getaccLikes()
 {
   return accLikes;
 }
 
 
}