/**
 * Purpose : Determines the number is a power of two or not after swapping the nibbles in binary
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.algorithmprograms;

import com.bridgelab.utility.Utility;

public class Binary {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the decimal number :");
		int decimal = utility.readInt();
		String binary = Utility.toBinary(decimal);
		System.out.println(binary);
		
		binary = Utility.swapNibbles(binary);
		System.out.println(binary);
		
		int decimal2 = Utility.toDecimal(binary);
		
		System.out.println("The new number after swapping the nibbles " + "is " + decimal2);
		
		if (Utility.isPowerOfTwo(decimal2))
			System.out.println("The number is power of 2.");
		else
			System.out.println("The number is not a power of 2.");
	}
}
