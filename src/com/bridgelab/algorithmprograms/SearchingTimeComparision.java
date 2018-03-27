/**
 * Purpose : Determines the performance of sorting and searching techniques
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.algorithmprograms;

import java.util.Arrays;

import com.bridgelab.functionalprograms.Stopwatch;
import com.bridgelab.utility.Utility;

public class SearchingTimeComparision {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String path = "/home/bridgeit/Desktop/List/dummyText.txt";
		String separator = " ";
		long[] elapsedTime = new long[6];
		String[] sortingTitles = { "Binary Search for integer", "Binary Search of String",
				"Insertion Sorting of Integer", "Insertion Sorting of String", "Bubble Sorting of Integer",
				"Bubble Sorting for String" };
		
		Integer[] intArray = Utility.generateRandomIntegers(100000, 100000);
		String[] stringArray = Utility.readStringsFromFile(path, separator);
		
		//for binary search for integers
		System.out.println("Enter the Number to search :");
		int number = utility.readInt();
		utility.readLine();
		Arrays.sort(intArray);
		Stopwatch stopwatch = new Stopwatch();

		stopwatch.start();
		int position = Utility.binarySearch(intArray, number);
		stopwatch.stop();

		if (position == -1)
			System.out.println("Number not Found");
		else
			System.out.println("Found at position " + (position + 1));
		sortingTitles[0] += stopwatch.getElapsedTimeInMinutes();
		elapsedTime[0] = stopwatch.getElapsedTime();
		Arrays.sort(stringArray);

		//binary search for string
		System.out.println("\nEnter word To search : ");
		String word = utility.readLine();

		stopwatch.start();
		position = Utility.binarySearch(stringArray, word);
		stopwatch.stop();

		if (position == -1)
			System.out.println("Word not Found");
		else
			System.out.println("Found at position " + (position + 1));
		sortingTitles[1] += stopwatch.getElapsedTimeInMinutes();
		elapsedTime[1] = stopwatch.getElapsedTime();
		Integer[] intArray1 = Utility.generateRandomIntegers(100000, 100000);

		
		//insertion sorting for integers
		stopwatch.start();
		Utility.insertionSort(intArray1);
		stopwatch.stop();

		sortingTitles[2] += stopwatch.getElapsedTimeInMinutes();
		elapsedTime[2] = stopwatch.getElapsedTime();
		String[] stringArray1 = Utility.readStringsFromFile(path, separator);

		//insertion sorting for strings
		stopwatch.start();
		Utility.insertionSort(stringArray1);
		stopwatch.stop();

		sortingTitles[3] += stopwatch.getElapsedTimeInMinutes();
		elapsedTime[3] = stopwatch.getElapsedTime();
		Integer[] intArray2 = Utility.generateRandomIntegers(100000, 100000);

		
		//bubble sorting for integers
		stopwatch.start();
		Utility.bubbleSort(intArray2);
		stopwatch.stop();

		sortingTitles[4] += stopwatch.getElapsedTimeInMinutes();
		elapsedTime[4] = stopwatch.getElapsedTime();
		String[] stringArray2 = Utility.readStringsFromFile(path, separator);

		//bubble sorting for strings
		stopwatch.start();
		Utility.bubbleSort(stringArray2);
		stopwatch.stop();
		sortingTitles[5] += stopwatch.getElapsedTimeInMinutes();
		elapsedTime[5] = stopwatch.getElapsedTime();

		//sorting the time taken for sorting and searching
		int n = elapsedTime.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (elapsedTime[j] < elapsedTime[j + 1]) {
					long longTemp = elapsedTime[j];
					elapsedTime[j] = elapsedTime[j + 1];
					elapsedTime[j + 1] = longTemp;
					String stringTemp = sortingTitles[j];
					sortingTitles[j] = sortingTitles[j + 1];
					sortingTitles[j + 1] = stringTemp;
				}
		
		//printing the time taken for sorting and searching
		for (int i = 0; i < sortingTitles.length; i++)
			System.out.println(sortingTitles[i]);
	}
}
