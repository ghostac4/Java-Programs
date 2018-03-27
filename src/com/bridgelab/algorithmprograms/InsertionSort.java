/**
 * Purpose : Implementation of insertion sort
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.algorithmprograms;

import com.bridgelab.utility.Utility;

public class InsertionSort {

	public static void main(String[] args) {
		Utility utility = new Utility();
		
		System.out.println("Enter words with space in between : ");
		String words = utility.readLine();
		
		String[] wordList = words.split(" ");
		
		Utility.insertionSort(wordList);
		
		for (String word : wordList)
			System.out.print(word + " ");
	}

}
