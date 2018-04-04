/**
 * Purpose : Interface socket adapter for Adapter Design pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 23-03-2018
 */
package com.bridgelabz.adapterpattern;

public interface SocketAdapter
{

   public Volt get120Volt();

   public Volt get12Volt();

   public Volt get3Volt();

}
