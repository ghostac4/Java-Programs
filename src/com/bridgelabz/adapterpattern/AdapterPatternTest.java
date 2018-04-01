
/**
 * Purpose : Implementation of Adapter Design pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 23-03-2018
 */

package com.bridgelab.designpattern.structuraldesignpatterns;

public class AdapterPatternTest {

	public static void main(String[] args) {
		testObjectAdapter();
		testClassAdapter();
	}

	/**
	 * function to implement adapter pattern using object adapter
	 */
	private static void testObjectAdapter(){
		SocketAdapter socketAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(socketAdapter, 3);
		Volt v12 = getVolt(socketAdapter, 12);
		Volt v120 = getVolt(socketAdapter, 120);
		
		System.out.print("\nv3 volt using object adapter :"+v3.getVolts());
		System.out.print("\nv12 volt using object adapter :"+v12.getVolts());
		System.out.print("\nv120 volt using object adapter :"+v120.getVolts());
	}
	
	/**
	 * function to implement adapter pattern using class adapter
	 */
	private static void testClassAdapter(){
		SocketAdapter socketAdapter = new SocketClassAdapterImpl();
		Volt v3 = getVolt(socketAdapter, 3);
		Volt v12 = getVolt(socketAdapter, 12);
		Volt v120 = getVolt(socketAdapter, 120);
		
		System.out.print("\nv3 volt using object adapter :"+v3.getVolts());
		System.out.print("\nv12 volt using object adapter :"+v12.getVolts());
		System.out.print("\nv120 volt using object adapter :"+v120.getVolts());
	}
	
	private static Volt getVolt(SocketAdapter socketAdapter, int i) {
		switch (i) {
		case 3:
			return socketAdapter.get3Volt();
		case 12:
			return socketAdapter.get12Volt();
		case 120:
			return socketAdapter.get120Volt();
		}
		return null;
	}
}
