/**
 * Purpose : Double ended node class for double ended queue
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is generic type
 */
package com.bridgelabz.utility;

public class DENode<T>
{

   private DENode<T> nextNode;
   private DENode<T> previousNode;
   private T t;

   /**
    * function to get next node
    * 
    * @return nextNode is a DENode<T>
    */
   public DENode<T> getNextNode()
   {
      return nextNode;
   }

   /**
    * function to get previous node
    * 
    * @return nextNode is a DENode<T>
    */
   public DENode<T> getPreviousNode()
   {
      return previousNode;
   }

   /**
    * function to set next node
    * 
    * @param nextNode is a DENode<T>
    */
   public void setNextNode(DENode<T> nextNode)
   {
      this.nextNode = nextNode;
   }

   /**
    * function to set previous node
    * 
    * @param previousNode is a DENode<T>
    */
   public void setPreviousNode(DENode<T> previousNode)
   {
      this.previousNode = previousNode;
   }

   /**
    * function to get data
    * 
    * @return t is generic element
    */
   public T getData()
   {
      return t;
   }

   /**
    * function to set data
    * 
    * @param t is a generic element
    */
   public void setData(T t)
   {
      this.t = t;
   }
}
