/**
 * Purpose : Implementation of Factory Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelabz.factorypattern;

public class TestFactory
{

   public static void main(String[] args)
   {
      Computer pc = ComputerFactory.getComputer("pc", "8GB", "1TB", "2.4GHz");

      Computer server = ComputerFactory.getComputer("server", "16GB", "12TB", "2.5GHz");

      System.out.print("\n" + pc);

      System.out.print("\n" + server);
   }

}
