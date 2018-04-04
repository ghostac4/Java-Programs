package com.bridgelabz.singletonpattern;

public class EagerInitializationSingleton
{

   private static final EagerInitializationSingleton EAGER_INITIALIZATION_SINGLETON = new EagerInitializationSingleton();

   private EagerInitializationSingleton()
   {
   }

   public static EagerInitializationSingleton getInstance()
   {
      return EAGER_INITIALIZATION_SINGLETON;
   }
}
