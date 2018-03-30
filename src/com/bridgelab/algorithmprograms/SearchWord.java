/**
 * Purpose : Searching word using binary search
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.algorithmprograms;

import java.util.Arrays;

import com.bridgelab.utility.Utility;

public class SearchWord {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String path = "wordList.txt";
		String separator = " ";
		String[] wordList = Utility.readStringsFromFile(path, separator);
		Arrays.sort(wordList);

		for (String word : wordList)
			System.out.print(word + " ");

		System.out.print("\nEnter the word to be searched : ");
		String keyword = utility.readLine();
		int position = Utility.binarySearch(wordList, keyword.trim());

		if (position == -1)
			System.out.print("Word not found");
		else
			System.out.print("Word Found at position " + (position + 1));
	}

}
