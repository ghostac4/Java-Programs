/**
 * Purpose : Finds a number from 0 to 2^N by asking N question using binary search 
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */
package com.bridgelab.algorithmprograms;

import com.bridgelab.utility.Utility;

public class GuessNumber {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the number N : ");
		int N = utility.readInt();
		int range = (int) Math.pow(2, N);
		System.out.println("Think a number between 0 to " + (range-1) + " and answer " + "following questions with 'y' and 'n'.");
		System.out.println("Press Enter to Continue .");
		utility.readLine();
		utility.readLine();
		int[] numberArray = new int[range];
		
		for (int i = 0; i < numberArray.length; i++)
			numberArray[i] = i;
		
		System.out.println("The number is : "+Utility.binarySearch(numberArray));
	}

}
