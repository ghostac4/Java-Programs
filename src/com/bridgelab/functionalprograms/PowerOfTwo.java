
/**
 * Purpose : Generates a table of powers of that are less than or equal to 2^N
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */

package com.bridgelab.functionalprograms;

import com.bridgelab.utility.Utility;

public class PowerOfTwo {

	public static void main(String args[]) {
		Utility utility = new Utility();
		int number, value = 1;
		
		do {
			System.out.println("Enter Number between 0 and 31 :");
			number = utility.readInt();
		} while (!(number >= 0 && number < 31));
		
		for (int i = 0; i < number; i++) {
			
			if (i == 0)
				value = 1;
			else
				value = value * 2;
			
			System.out.println("Power of 2^" + i + " : " + value);
		}
	}
}
