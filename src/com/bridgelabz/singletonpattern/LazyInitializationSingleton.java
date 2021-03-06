package com.bridgelabz.singletonpattern;

public class LazyInitializationSingleton
{

   private static LazyInitializationSingleton lazyInitializationSingleton;

   private LazyInitializationSingleton()
   {
   }

   public static LazyInitializationSingleton getInstance()
   {
      if (lazyInitializationSingleton == null)
         lazyInitializationSingleton = new LazyInitializationSingleton();
      return lazyInitializationSingleton;
   }
}
