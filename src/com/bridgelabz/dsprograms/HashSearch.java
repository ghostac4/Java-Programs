/**
 * Purpose : Hashing Function to search a Number in a slot
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.dsprograms;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bridgelab.utility.OrderedList;
import com.bridgelab.utility.Utility;

public class HashSearch {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String path = "outputList.txt";

		int choice;
		Map<Integer, OrderedList<Integer>> map = new LinkedHashMap<>();

		for (int i = 0; i < 11; i++)
			map.put(i, new OrderedList<>());

		String[] intString = Utility.readStringsFromFile(path, " ");

		for (int i = 0; i < intString.length; i++) {
			int temp = Integer.parseInt(intString[i]);
			int remainder = temp % 11;
			OrderedList<Integer> olist = map.get(remainder);
			if (olist.search(temp))
				olist.remove(temp);
			else
				olist.add(temp);
		}

		do {
			System.out.print("\nEnter the choice : 1.Add Number to Slot.");
			System.out.print("\n                   2.Search Number.");
			System.out.print("\n                   3.Display.");
			System.out.print("\n                   4.Quit.");
			choice = utility.readInt();
			switch (choice) {
			case 1:
				System.out.print("\nEnter the number : ");
				int number = utility.readInt();
				int remainder = number % 11;
				OrderedList<Integer> olist = map.get(remainder);
				if (olist.search(number)) {
					olist.remove(number);
					System.out.print("\n The number is removed from list :" + number);
				} else {
					olist.add(number);
					System.out.print("\n The number is inserted");
				}
				break;
			case 2:
				System.out.print("\nEnter the number : ");
				int number2 = utility.readInt();
				int remainder2 = number2 % 11;
				OrderedList<Integer> olist2 = map.get(remainder2);
				if (olist2.search(number2)) {
					olist2.remove(number2);
					System.out.print("\n The number is removed from list :" + number2);
				} else {
					olist2.add(number2);
					System.out.print("\n The number is inserted");
				}
				break;
			case 3:
				for (int i = 0; i < 11; i++) {
					OrderedList<Integer> olist3 = map.get(i);
					System.out.print("\n" + i + " : ");
					olist3.display();
				}
				break;
			case 4:
			default:
				break;
			}
		} while (choice != 4);

		String wordList = "";
		for (int i = 0; i < 11; i++) {
			OrderedList<Integer> olist4 = map.get(i);
			int size = olist4.size();
			if (size != 0) {
				for (int j = 0; j < size; j++) {
					wordList = wordList + olist4.pop() + " ";
				}
			}
		}

		Utility.writeToFile(wordList, path);
	}

}
