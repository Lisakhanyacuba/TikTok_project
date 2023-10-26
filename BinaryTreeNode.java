//Lisakhanya Cuba
//CBXLIS001
//14 April 2022
import java.util.*;
/**The BinaryTreeNode class
which is the base of the BinarySearchTree*/
public class BinaryTreeNode
 {
   Account data ;
   BinaryTreeNode left;
   BinaryTreeNode right;
  /**The BinaryTree constructor.*/
   public BinaryTreeNode( Account d , BinaryTreeNode l , BinaryTreeNode r)
   {
    data = d ;
    left =l;
    right = r ;
   }
  BinaryTreeNode getLeft() 
  {
  return left;
  } 
  BinaryTreeNode getRight()
   {
   return right;
   }
   }


