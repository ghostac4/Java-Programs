/**
 * Purpose : Head node class for double ended queue
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
package com.bridgelabz.utility;

public class HeadDENode<T>
{

   private DENode<T> firstNode;

   /**
    * function to set first node
    * 
    * @param firstNode is a DENode<T>
    */
   public void setFirstNode(DENode<T> firstNode)
   {
      this.firstNode = firstNode;
   }

   /**
    * function to get first node
    * 
    * @return first is a DENode<T>
    */
   public DENode<T> getFirstNode()
   {
      return firstNode;
   }
}
