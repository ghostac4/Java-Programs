/**
 * Purpose : Calculates the monthly payment for given principal amount,year and
 * rate
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.algorithmprograms;

import com.bridgelab.utility.Utility;

public class MonthlyPayment {

	public static void main(String[] args) {

		float principal = Float.parseFloat(args[0]);
		float year = Float.parseFloat(args[1]);
		float rate = Float.parseFloat(args[2]);

		System.out.println(Utility.monthlyPayment(principal, year, rate));
	}

}
