/**
 * Purpose : Computes the prime factorization of N using brute force.
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */

package com.bridgelab.functionalprograms;

import com.bridgelab.utility.Utility;

public class Factors {

	public static void main(String args[]) {

		Utility utility = new Utility();
		System.out.println("Enter the number :");

		int number = utility.readInt();

		for (int i = 2; i * i <= number; i++) {

			if (number % i == 0)
				if (Utility.isPrime(i))
					System.out.println(i);
		}
	}
}
