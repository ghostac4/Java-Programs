/**
 * Purpose : class task for task scheduling program
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

public class Task implements Comparable<Task>, Cloneable
{

   private int taskId;
   private int deadline;
   private int minutes;

   public int getTaskId()
   {
      return taskId;
   }

   public void setTaskId(int taskId)
   {
      this.taskId = taskId;
   }

   public int getDeadline()
   {
      return deadline;
   }

   public void setDeadline(int deadline)
   {
      this.deadline = deadline;
   }

   public int getMinutes()
   {
      return minutes;
   }

   public void setMinutes(int minutes)
   {
      this.minutes = minutes;
   }

   @Override
   public int compareTo(Task task)
   {
      if (this.deadline == task.getDeadline())
         return 0;
      else if (this.deadline > task.getDeadline())
         return 1;
      else
         return -1;
   }

   public Object clone() throws CloneNotSupportedException
   {
      return super.clone();
   }
}
