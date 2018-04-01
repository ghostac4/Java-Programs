/**
 * Purpose : Determines the harmonic value of a given number
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */

package com.bridgelab.functionalprograms;

import com.bridgelab.utility.Utility;

public class HarmonicNumber {

	public static void main(String args[]) {
		Utility utility = new Utility();

		int number;
		float harmonicValue = 0.0f;

		do {
			System.out.println("Enter Number :");
			number = utility.readInt();
		} while (number == 0);

		//Calculates harmonic value for number
		for (int i = 1; i <= number; i++)
			harmonicValue = harmonicValue + (1.0f / i);

		System.out.println("Harmonic Value of " + number + " : " + harmonicValue);
	}
}
