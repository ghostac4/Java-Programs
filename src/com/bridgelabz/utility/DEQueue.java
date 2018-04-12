/**
 * Purpose : Class for double ended queue
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T>
 *            is a generice type
 */
package com.bridgelabz.utility;

public class DEQueue<T>
{

   private HeadDENode<T> front;
   private HeadDENode<T> rear;
   private int sizeCount = 0;

   /**
    * constructor for DEQueue class
    */
   public DEQueue()
   {
      front = new HeadDENode<>();
      rear = new HeadDENode<>();
   }

   /**
    * This method adds the element in front of queue
    * 
    * @param t is generic type
    */
   public void addFront(T t)
   {
      DENode<T> denode = new DENode<>();
      if (front.getFirstNode() == null && rear.getFirstNode() == null) {
         denode.setData(t);
         front.setFirstNode(denode);
         rear.setFirstNode(denode);
         sizeCount++;
      } else {
         DENode<T> nextNode = front.getFirstNode();
         denode.setData(t);
         denode.setNextNode(nextNode);
         nextNode.setPreviousNode(denode);
         front.setFirstNode(denode);
         sizeCount++;
      }
   }

   /**
    * This method adds the element in rear of queue
    * 
    * @param t is generic type
    */
   public void addRear(T t)
   {
      DENode<T> denode = new DENode<>();
      if (front.getFirstNode() == null && rear.getFirstNode() == null) {
         denode.setData(t);
         front.setFirstNode(denode);
         rear.setFirstNode(denode);
         sizeCount++;
      } else {
         DENode<T> lastNode = rear.getFirstNode();
         denode.setData(t);
         denode.setPreviousNode(lastNode);
         lastNode.setNextNode(denode);
         rear.setFirstNode(denode);
         sizeCount++;
      }
   }

   /**
    * @return T is generic type
    */
   public T removeFront()
   {
      DENode<T> denode = front.getFirstNode();
      if (front.getFirstNode() == rear.getFirstNode()) {
         front.setFirstNode(null);
         rear.setFirstNode(null);
         sizeCount--;
         return denode.getData();
      } else {
         front.setFirstNode(denode.getNextNode());
         T t = denode.getData();
         denode.setNextNode(null);
         denode = front.getFirstNode();
         denode.setPreviousNode(null);
         sizeCount--;
         return t;
      }
   }

   /**
    * function to remove last node from queue
    * 
    * @return a generic type of removed node
    */
   public T removeRear()
   {
      DENode<T> denode = rear.getFirstNode();
      if (front.getFirstNode() == rear.getFirstNode()) {
         front.setFirstNode(null);
         rear.setFirstNode(null);
         sizeCount--;
         return denode.getData();
      } else {
         rear.setFirstNode(denode);
         T t = denode.getData();
         denode.setPreviousNode(null);
         denode = rear.getFirstNode();
         denode.setNextNode(null);
         sizeCount--;
         return t;
      }
   }

   /**
    * check if the queue is empty or not
    * 
    * @return true if the queue is empty else false
    */
   public boolean isEmpty()
   {
      return (front.getFirstNode() == null && rear.getFirstNode() == null);
   }

   /**
    * function to return size of queue
    * 
    * @return number of size of queue
    */
   public int size()
   {
      return sizeCount;
   }

   /**
    * function to display the elements from the queue
    */
   public void displayFromFront()
   {
      DENode<T> denode = front.getFirstNode();
      if (denode.getNextNode() == null) {
         System.out.print("\n" + denode.getData());
      } else {
         while (denode.getNextNode() != null) {
            System.out.print(denode.getData() + " ");
            denode = denode.getNextNode();
         }
         System.out.print(denode.getData() + " ");
      }
   }
}
