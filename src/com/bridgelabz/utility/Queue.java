/**
 * Purpose : Programs for queue using linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
package com.bridgelabz.utility;

public class Queue<T>
{

   private HeadNode<T> rear;
   private HeadNode<T> front;
   private int sizeCount = 0;

   /**
    * constructor to initialize the front and rear head
    */
   public Queue()
   {
      rear = new HeadNode<>();
      front = new HeadNode<>();
   }

   /**
    * function to insert element into the queue
    * 
    * @param t is a generic type
    */
   public void enqueue(T t)
   {
      if (rear.getFirstNode() == null && front.getFirstNode() == null) {
         Node<T> node = new Node<>();
         node.setData(t);
         rear.setFirstNode(node);
         front.setFirstNode(node);
         sizeCount++;
      } else {
         Node<T> node = new Node<>();
         node.setData(t);
         Node<T> endNode = rear.getFirstNode();
         endNode.setNextNode(node);
         rear.setFirstNode(node);
         sizeCount++;
      }
   }

   /**
    * function to remove element from the queue
    * 
    * @return removed element
    */
   public T dequeue()
   {
      if (rear.getFirstNode() == front.getFirstNode()) {
         if (front.getFirstNode() == null)
            return null;
         Node<T> firstNode = front.getFirstNode();
         rear.setFirstNode(null);
         front.setFirstNode(null);
         sizeCount--;
         return firstNode.getData();
      } else {
         Node<T> firstNode = front.getFirstNode();
         front.setFirstNode(firstNode.getNextNode());
         firstNode.setNextNode(null);
         sizeCount--;
         return firstNode.getData();
      }
   }

   /**
    * function to check the queue is empty or not
    * 
    * @return true if the queue is empty else false
    */
   public boolean isEmpty()
   {
      if (rear.getFirstNode() == null && rear.getFirstNode() == null)
         return true;
      return false;
   }

   /**
    * function to get the size of queue
    * 
    * @return number of size
    */
   public int size()
   {
      return sizeCount;
   }

   /**
    * function to display the elements from the queue
    */
   public void display()
   {
      Node<T> currentNode = front.getFirstNode();
      if (currentNode == null) {
         System.out.println("Queue Empty");
      } else {
         do {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
         } while (currentNode != rear.getFirstNode());
         System.out.print(currentNode.getData() + " ");
      }
   }
}
