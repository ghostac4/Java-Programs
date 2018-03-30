/**
 * Purpose : Implementation of an ordered linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelab.dsprograms;

import com.bridgelab.utility.OrderedList;
import com.bridgelab.utility.Utility;

public class OrderedListImpl {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String path = "intList.txt";
		String separator = " ";
		String[] intStringList = Utility.readStringsFromFile(path, separator);
		Integer[] intList = new Integer[intStringList.length];
		for (int i = 0; i < intStringList.length; i++) {
			intList[i] = Integer.parseInt(intStringList[i]);
			System.out.print(intList[i] + " ");
		}
		
		OrderedList<Integer> olist = new OrderedList<>();
		System.out.print("\nEnter the number to remove or insert into list : ");
		Integer number = utility.readInt();
		
		for (Integer integer : intList)
			olist.add(integer);
		
		if (olist.search(number)) {
			olist.remove(number);
			System.out.print("\n The number is removed from list :" + number);
		} else {
			olist.add(number);
			System.out.print("\n The number is inserted");
		}

		System.out.print("\n");
		olist.display();
		String wordList = "";
		
		int size = olist.size();
		for (int i = 0; i < size; i++)
			wordList = wordList + olist.pop() + " ";
		
		//System.out.print("\n" + wordList);
		
		//Utility.writeToFile(wordList, path);
	}

}
