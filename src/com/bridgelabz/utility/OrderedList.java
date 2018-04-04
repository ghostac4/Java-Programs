/**
 * Purpose : Program for ordered list using linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
package com.bridgelabz.utility;

public class OrderedList<T extends Comparable<T>>
{

   private HeadNode<T> headNode;
   private int sizeCount;

   /**
    * constructor for OrderedList class
    */
   public OrderedList()
   {
      headNode = new HeadNode<>();
      sizeCount = 0;
   }

   /**
    * function to add the node at the end
    * 
    * @param t is a generic type
    */
   public void add(T t)
   {
      if (headNode.getFirstNode() == null) {
         Node<T> node = new Node<>();
         node.setData(t);
         headNode.setFirstNode(node);
         sizeCount++;
      } else {
         Node<T> temp = null;
         Node<T> currentNode = headNode.getFirstNode();
         while (currentNode.getNextNode() != null && currentNode.getData().compareTo(t) < 0) {
            temp = currentNode;
            currentNode = currentNode.getNextNode();
         }

         if (currentNode.getNextNode() == null) {
            Node<T> node = new Node<>();
            node.setData(t);
            if (currentNode.getData().compareTo(t) < 0) {
               currentNode.setNextNode(node);
            } else {
               if (temp == null) {
                  node.setNextNode(currentNode);
                  headNode.setFirstNode(node);
               } else {
                  node.setNextNode(currentNode);
                  temp.setNextNode(node);
               }
            }
         } else {
            if (temp == null) {
               Node<T> node = new Node<>();
               node.setData(t);
               if (currentNode.getData().compareTo(t) < 0) {
                  currentNode.setNextNode(node);
               } else {
                  node.setNextNode(currentNode);
                  headNode.setFirstNode(node);
               }
            } else {
               Node<T> node = new Node<>();
               node.setData(t);
               node.setNextNode(currentNode);
               temp.setNextNode(node);
            }
         }
         sizeCount++;
      }
   }

   /**
    * function to check if the list is empty or not
    * 
    * @return true if the list is empty else false
    */
   public boolean isEmpty()
   {
      if (headNode.getFirstNode() == null)
         return true;
      return false;
   }

   public T pop(int position)
   {
      Node<T> currentNode = headNode.getFirstNode();
      Node<T> previouNode = null;
      int index = 1;
      while (currentNode.getNextNode() != null && !(index == position)) {
         previouNode = currentNode;
         currentNode = currentNode.getNextNode();
      }
      if (previouNode == null) {
         T t = currentNode.getData();
         headNode.setFirstNode(currentNode.getNextNode());
         sizeCount--;
         return t;
      } else {
         T t = currentNode.getData();
         previouNode.setNextNode(currentNode.getNextNode());
         currentNode.setNextNode(null);
         sizeCount--;
         return t;
      }
   }

   /**
    * function to remove the given element
    * 
    * @param t is a generic type
    */
   public void remove(T t)
   {
      Node<T> currentNode = headNode.getFirstNode();
      Node<T> previouNode = null;
      while (currentNode.getNextNode() != null && !(currentNode.getData().equals(t))) {
         previouNode = currentNode;
         currentNode = currentNode.getNextNode();
      }
      if (currentNode.getNextNode() == null) {
         if (currentNode.getData().equals(t)) {
            if (previouNode == null) {
               sizeCount--;
               headNode.setFirstNode(currentNode.getNextNode());
            } else {
               sizeCount--;
               previouNode.setNextNode(null);
            }
         }
      } else {
         if (previouNode == null) {
            sizeCount--;
            headNode.setFirstNode(currentNode.getNextNode());
         } else {
            previouNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(null);
            sizeCount--;
         }
      }
   }

   /**
    * function to remove the element from the end
    * 
    * @return the last element
    */
   public T pop()
   {
      Node<T> currentNode = headNode.getFirstNode();
      Node<T> previouNode = null;
      while (currentNode.getNextNode() != null) {
         previouNode = currentNode;
         currentNode = currentNode.getNextNode();
      }
      if (previouNode == null) {
         T t = currentNode.getData();
         headNode.setFirstNode(null);
         sizeCount--;
         return t;
      } else {
         T t = currentNode.getData();
         previouNode.setNextNode(null);
         sizeCount--;
         return t;
      }
   }

   /**
    * function to determine the index for a given element
    * 
    * @param t is a generic type element
    * @return number of position at which the element is found
    */
   public int index(T t)
   {
      Node<T> currentNode = headNode.getFirstNode();
      int indexNumber = 1;
      while (currentNode.getNextNode() != null) {
         if (currentNode.getData().equals(t))
            return indexNumber;
         currentNode = currentNode.getNextNode();
      }
      return indexNumber;
   }

   /**
    * function to search the given element
    * 
    * @param t is a generic type
    * @return true if the element is found else false
    */
   public boolean search(T t)
   {
      Node<T> currentNode = headNode.getFirstNode();
      if (currentNode != null) {
         while (currentNode.getNextNode() != null) {
            if (currentNode.getData().equals(t))
               return true;
            currentNode = currentNode.getNextNode();
         }
         if (currentNode.getData().equals(t))
            return true;
         return false;
      } else
         return false;
   }

   /**
    * function to display the elements from the list
    */
   public void display()
   {
      Node<T> currentNode = headNode.getFirstNode();
      if (currentNode == null) {
         System.out.print(" ");
      } else {
         while (currentNode.getNextNode() != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
         }
         System.out.print(currentNode.getData() + " ");
      }
   }

   /**
    * function to get the size of list
    * 
    * @return number of size
    */
   public int size()
   {
      return sizeCount;
   }
}
