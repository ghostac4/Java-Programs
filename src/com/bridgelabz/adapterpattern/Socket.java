/**
 * Purpose : Class Socket for Adapter Design pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 23-03-2018
 */
package com.bridgelabz.adapterpattern;

public class Socket
{

   /**
    * getter function to get volt
    * 
    * @return
    */
   public Volt getVolt()
   {
      return new Volt(120);
   }
}
