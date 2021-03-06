package com.bridgelabz.observerpattern;

public class MyTopicSubscriber implements Observer
{

   private String name;
   private Subject topic;

   /**
    * constructor for MyTopicSubscriber class
    * @param name
    */
   public MyTopicSubscriber(String name)
   {
      this.name = name;
   }

   @Override
   public void update()
   {
      String message = (String) topic.getUpdate(this);
      if (message == null)
         System.out.println(name + ":: No new message");
      else
         System.out.println(name + ":: Message::" + message);
   }

   @Override
   public void setSubject(Subject sub)
   {
      this.topic = sub;
   }

}
