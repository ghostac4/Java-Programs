/**
 * Purpose : Head node class for queue and linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
package com.bridgelabz.utility;

public class HeadNode<T>
{
   private Node<T> firstNode;

   /**
    * function to set first node
    * 
    * @param firstNode is a Node<T>
    */
   public void setFirstNode(Node<T> firstNode)
   {
      this.firstNode = firstNode;
   }

   /**
    * function to get first node
    * 
    * @return firstNode is a Node<T>
    */
   public Node<T> getFirstNode()
   {
      return firstNode;
   }
}
