package com.bridgelabz.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject
{

   private List<Observer> observers;
   private String message;
   private boolean changed;

   /**
    * constructor for MyTopic class
    */
   public MyTopic()
   {
      observers = new ArrayList<Observer>();
   }

   @Override
   public void register(Observer obj)
   {
      if (obj == null)
         throw new NullPointerException("Null Observer");
      if (!observers.contains(obj))
         observers.add(obj);
   }

   @Override
   public void unregister(Observer obj)
   {
      observers.remove(obj);
   }

   @Override
   public void notifyObservers()
   {
      if (changed) {
         for (Observer observer : observers)
            observer.update();
      }
   }

   @Override
   public Object getUpdate(Observer obj)
   {
      return this.message;
   }

   public void postMessage(String message)
   {
      System.out.println("Message Posted to Topic:" + message);
      this.message = message;
      this.changed = true;
      notifyObservers();
   }

}
