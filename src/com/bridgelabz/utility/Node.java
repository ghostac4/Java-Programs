/**
 * Purpose : Class Node for Linked List Implementation
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
package com.bridgelabz.utility;

public class Node<T>
{
   private T t;
   private Node<T> nextNode;

   /**
    * function to set next node
    * 
    * @param nextNode is a Node<T>
    */
   public void setNextNode(Node<T> nextNode)
   {
      this.nextNode = nextNode;
   }

   /**
    * function to get next node
    * 
    * @return nextNode is a Node<T>
    */
   public Node<T> getNextNode()
   {
      return nextNode;
   }

   /**
    * function to set data
    * 
    * @param data is a generic element
    */
   public void setData(T data)
   {
      this.t = data;
   }

   /**
    * function to get data
    * 
    * @return t is a generic element
    */
   public T getData()
   {
      return t;
   }
}
