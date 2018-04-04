
/**
 * Purpose : Measures the time elapsed between the start and end click
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Stopwatch
{

   long mfirst;
   long msecond;
   long melapsed;

   /**
    * Stores the start time
    */
   public void start()
   {
      mfirst = System.currentTimeMillis();
   }

   /**
    * Stores end time
    */
   public void stop()
   {
      msecond = System.currentTimeMillis();
   }

   /**
    * @return long current time in millis
    */
   public long getElapsedTime()
   {
      return melapsed;
   }

   /**
    * @return String the elapsed time in readable format like
    *         minutes:seconds:millis
    */
   public String getElapsedTimeInMinutes()
   {
      melapsed = msecond - mfirst;
      int seconds = (int) melapsed / 1000;
      int milli = (int) melapsed % 1000;
      int minutes = (int) seconds / 60;
      seconds = seconds % 60;
      return "Time  :      " + minutes + ":" + seconds + ":" + milli;
   }

   @SuppressWarnings("unused")
   public static void main(String[] args)
   {
      Utility utility = new Utility();

      System.out.println("Press Enter To start/Stop The stopwatch");

      String enterkey = utility.readLine();
      Stopwatch stopwatch = new Stopwatch();
      stopwatch.start();
      System.out.println("Stopwatch Started...");

      System.out.println("Press Enter To Stop The stopwatch");
      enterkey = utility.readLine();
      System.out.println("Stopwatch Stopped.");

      System.out.println("*******Time*******");
      stopwatch.stop();
      System.out.println(stopwatch.getElapsedTimeInMinutes());
      System.out.println("******************");
   }
}
