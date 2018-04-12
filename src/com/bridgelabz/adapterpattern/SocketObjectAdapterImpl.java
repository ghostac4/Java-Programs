package com.bridgelabz.adapterpattern;

public class SocketObjectAdapterImpl implements SocketAdapter
{

   private Socket socket = new Socket();

   @Override
   public Volt get120Volt()
   {
      return socket.getVolt();
   }

   @Override
   public Volt get12Volt()
   {
      Volt volt = socket.getVolt();
      return convertTo(volt, 10);
   }

   @Override
   public Volt get3Volt()
   {
      Volt volt = socket.getVolt();
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
