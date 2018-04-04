/**
 * Purpose : Program for stack using linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is generic type
 */
package com.bridgelabz.utility;

public class Stack<T>
{

   private HeadNode<T> headNode;
   private int size = 0;

   /**
    * constructor to initialize headnode
    */
   public Stack()
   {
      headNode = new HeadNode<>();
   }

   /**
    * function to push element into the stack
    * 
    * @param t is generic type
    */
   public void push(T t)
   {
      Node<T> topNode = headNode.getFirstNode();
      if (topNode == null) {
         Node<T> node = new Node<>();
         node.setData(t);
         node.setNextNode(null);
         headNode.setFirstNode(node);
         size++;
      } else {
         Node<T> node = new Node<>();
         node.setData(t);
         node.setNextNode(headNode.getFirstNode());
         headNode.setFirstNode(node);
         size++;
      }
   }

   /**
    * function to pop the element from the stack
    * 
    * @return T generic type element
    */
   public T pop()
   {
      Node<T> topNode = headNode.getFirstNode();
      if (topNode == null) {
         return null;
      } else {
         headNode.setFirstNode(topNode.getNextNode());
         topNode.setNextNode(null);
         size--;
         return topNode.getData();
      }
   }

   /**
    * function to look the top element of a stack
    * 
    * @return T generic type element
    */
   public T peek()
   {
      Node<T> topNode = headNode.getFirstNode();
      if (topNode == null)
         return null;
      else
         return topNode.getData();
   }

   /**
    * function to check if the stack is empty or not
    * 
    * @return true if the stack is empty else false
    */
   public boolean isEmpty()
   {
      Node<T> topNode = headNode.getFirstNode();
      if (topNode == null)
         return true;
      else
         return false;
   }

   /**
    * function to get the size of the stack
    * 
    * @return number of size
    */
   public int size()
   {
      return size;
   }
}
