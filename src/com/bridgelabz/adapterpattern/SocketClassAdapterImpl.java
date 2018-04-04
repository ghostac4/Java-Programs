/**
 * Purpose : Implementation socket class adapter of Adapter Design pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 23-03-2018
 */
package com.bridgelabz.adapterpattern;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter
{

   @Override
   public Volt get120Volt()
   {
      return getVolt();
   }

   @Override
   public Volt get12Volt()
   {
      Volt volt = getVolt();
      return convertTo(volt, 10);
   }

   @Override
   public Volt get3Volt()
   {
      Volt volt = getVolt();
      return convertTo(volt, 40);
   }

   /**
    * function to convert volts
    * @param volt is Volt class 
    * @param i is a number
    * @return Volt object
    */
   private Volt convertTo(Volt volt, int i)
   {
      return new Volt(volt.getVolts() / i);
   }

}
