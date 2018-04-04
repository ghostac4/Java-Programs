
/**
 * Purpose : Using Reflection to destroy singleton pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */

package com.bridgelabz.singletonpattern;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest
{

   @SuppressWarnings("rawtypes")
   public static void main(String[] args)
   {
      EagerInitializationSingleton eagerInitializationSingleton1 = EagerInitializationSingleton.getInstance();
      EagerInitializationSingleton eagerInitializationSingleton2 = null;

      try {
         Constructor[] constructors = EagerInitializationSingleton.class.getDeclaredConstructors();

         for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            eagerInitializationSingleton2 = (EagerInitializationSingleton) constructor.newInstance();
            break;
         }
      } catch (Exception e) {
         System.out.print("\n" + e.toString());
      }

      System.out.print("\n" + eagerInitializationSingleton1.hashCode());
      System.out.print("\n" + eagerInitializationSingleton2.hashCode());
   }

}
