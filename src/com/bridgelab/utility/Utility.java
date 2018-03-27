/**
 * Purpose : Contains all the most frequently used functions 
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */
package com.bridgelab.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Utility {
	private Scanner sc;

	public Utility() {
		sc = new Scanner(System.in);
	}

	
	/**
	 * @return integer from console
	 */
	public int readInt() {
		return sc.nextInt();
	}

	/**
	 * @return string from console
	 */
	public String readLine() {
		return sc.nextLine();
	}

	/**
	 * @return float from console
	 */
	public float readFloat() {
		return sc.nextFloat();
	}

	/**
	 * function to detect if the given strings are anagram or not
	 * @param string1 is a string
	 * @param string2 is a string
	 * @return true if strings are anagram else false
	 * 
	 */
	public boolean detectAnagram(String string1, String string2) {
		String[] string1Strings = string1.split(" ");
		String[] string2Strings = string2.split(" ");
		String tempString1="",tempString2="";
		
		for(String string : string1Strings)
			tempString1 +=string;
		for(String string : string2Strings)
			tempString2 +=string;
		
		if (tempString1.length() == tempString2.length()) {
			char[] string1chars = tempString1.toCharArray();
			char[] string2chars = tempString2.toCharArray();

			Arrays.sort(string1chars);
			Arrays.sort(string2chars);

			string1 = new String(string1chars);
			string2 = new String(string2chars);

			if (string1.equals(string2)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	/**This method returns list of integers upto given range
	 * @param range is an integer 
	 * @return list is an arraylist
	 */
	public List<Integer> getPrimeNumbers(int range) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < range; i++) {
			boolean flag = false;
			if (i == 0 || i == 1) {
				continue;
			} else {
				for (int j = 2; j <= i / 2; j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					list.add(i);
				}
			}
		}
		return list;
	}

	/**
	 * function to check if two strings are palindrome or not
	 * @param string1 is a String
	 * @param string2 is a String
	 * @return boolean true if the strings are palindrome else false
	 */
	public boolean isPalindrome(String string1, String string2) {
		int string1Length = string1.length();
		int string2Length = string2.length();
		if (string1Length == string2Length) {
			for(int i=0;i<string1Length ;i++){
				if(string1.charAt(i) != string2.charAt(string2Length-i-1))
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * function to get all the strings which are anagram from given list
	 * @param list is an ArrayList of integers
	 * @return LinkedHashMap having key and value String
	 */
	public Map<String, String> getAnagram(List<Integer> list) {
		Integer[] arrayList = list.toArray(new Integer[list.size()]);
		
		Map<String, String> anagrams = new LinkedHashMap<String, String>();
		
		for (int i = 0; i < arrayList.length - 1; i++) {
			for (int j = i + 1; j < arrayList.length; j++) {
				if (detectAnagram(arrayList[i] + "", arrayList[j] + "")) {
					anagrams.put(arrayList[i] + "", arrayList[j] + "");
				}
			}
		}
		return anagrams;
	}

	/**
	 * function to get all the palindromes from given list
	 * @param list is an Arraylist of Integers
	 * @return list is an Arraylist of integers
	 */
	public List<Integer> getPalindrome(List<Integer> list) {
		Integer[] arrayList = list.toArray(new Integer[list.size()]);
		
		List<Integer> palindromeList = new ArrayList<Integer>();
		
		for (int i = 0; i < arrayList.length - 1; i++) {
			for (int j = i + 1; j < arrayList.length; j++) {
				if (isPalindrome(arrayList[i] + "", arrayList[j] + "")) {
					palindromeList.add(arrayList[i]);
					palindromeList.add(arrayList[j]);
				}
			}
		}
		return palindromeList;
	}

	/**
	 * function for binary search an array
	 * @param array is integer array
	 * @return int is a element from array
	 */
	public static int binarySearch(int[] array) {
		return search(array, 0, array.length - 1);
	}

	/**
	 * function for binary search an array
	 * @param array is an integer array
	 * @param start is an starting index number
	 * @param end is end index number
	 * @return number of index at which the search is found
	 */
	public static int search(int[] array, int start, int end) {
		Utility utility = new Utility();
		if ((start - end) == 0) {
			return array[start];
		} else {
			int mid = (start + end) / 2;
			System.out.println("Is your Number Between " + start + " and " + mid);
			char answer = utility.readLine().charAt(0);
			if (answer == 'n' || answer == 'N')
				return search(array, mid + 1, end);
			else
				return search(array, start, mid);
		}
	}

	
	/**
	 * function for binary search a generic array
	 * @param array is a generic array
	 * @param keyword is generic type to be search in array
	 * @return number of index at which the keyword is found
	 */
	public static <E extends Comparable<T>, T> int binarySearch(E[] array, E keyword) {
		return search(array, 0, array.length - 1, keyword);
	}

	@SuppressWarnings("unchecked")
	public static <E extends Comparable<T>, T> int search(E[] array, int start, int end, E keyword) {
		if ((start - end) == 0) {
			if (array[start].compareTo((T) keyword) == 0)
				return start;
			return -1;
		} else {
			int mid = (start + end) / 2;
			if (array[mid].compareTo((T) keyword) == 0) {
				return mid;
			} else {
				if (keyword.compareTo((T) array[mid]) > 0) {
					return search(array, mid + 1, end, keyword);
				} else {
					return search(array, start, mid, keyword);
				}
			}
		}
	}

	
	/**
	 * function to sort generic array using insertion sort
	 * @param array is a generic array
	 * @return generic sorted array
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<T>, T> void insertionSort(E[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			E key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j].compareTo((T) key) > 0) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	
	/**
	 * function to sort the generic array using bubble sort
	 * @param array is a generic array
	 * @return generic sorted array
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<T>, T> void bubbleSort(E[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (array[j].compareTo((T) array[j + 1]) > 0) {
					E temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}

	
	/**
	 * function to sort the arrays using merge sort
	 * @param array is a string array
	 */
	public static void mergeSort(String[] array) {
		msort(array, 0, array.length-1);
	}

	public static void msort(String[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			msort(array, left, mid);
			msort(array, mid + 1, right);

			merge(array, left, mid, right);

		}
	}

	public static void merge(String[] array, int left, int mid, int right) {
		int subArrayLLength = mid - left + 1;
		int subArrayRLength = right - mid;

		String subArrayL[] = new String[subArrayLLength];
		String subArrayR[] = new String[subArrayRLength];
		for (int i = 0; i < subArrayLLength; ++i)
			subArrayL[i] = array[left + i];
		for (int j = 0; j < subArrayRLength; ++j)
			subArrayR[j] = array[mid + 1 + j];

		int i = 0, j = 0;
		int k = left;
		while (i < subArrayLLength && j < subArrayRLength) {
			if (subArrayL[i].compareTo(subArrayR[j]) < 0) {
				array[k] = subArrayL[i];
				i++;
			} else {
				array[k] = subArrayR[j];
				j++;
			}
			k++;
		}

		while (i < subArrayLLength) {
			array[k] = subArrayL[i];
			i++;
			k++;
		}

		while (j < subArrayRLength) {
			array[k] = subArrayR[j];
			j++;
			k++;
		}
	}

	/**
	 * Generates list of random integers with given range and number
	 * @param number random values required
	 * @param range is a range for random number generation
	 * @return array of integer
	 */
	public static Integer[] generateRandomIntegers(int number, int range) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		
		for (int i = 0; i < number; i++) {
			int randomInt = random.nextInt(range);
			
			if (i == 2) {
				list.add(10);
			}
			
			if (!list.contains(randomInt)) {
				list.add(randomInt);
			}
		}
		Integer[] intList = list.toArray(new Integer[list.size()]);
		return intList;
	}


	/**
	 * Reads strings from file and returns string array
	 * @param path is a string path from which strings to be read
	 * @param separator is string for splitting a sentence
	 * @return array of string
	 */
	public static String[] readStringsFromFile(String path, String separator) {
		List<String> stringList = new ArrayList<String>();
		String list[];
		String line;
		try {
			InputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				String words[] = line.split(separator);
				for (String word : words) {
					stringList.add(word);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		list = stringList.toArray(new String[stringList.size()]);
		return list;
	}

	/**
	 * Reads everything from file and returns string
	 * @param path is string format of path
	 * @return string from file
	 */
	public static String readFromFile(String path) {
		String line = "", output = "";
		try {
			InputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				output = output + line;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return output;
	}

	/**
	 * Gives Minimum no of notes required for specific change recursively
	 * @param change is a number
	 * @param changeTable is map containing change values
	 */
	public void getChange(int change, int[] changeCounts, int[] changeArray) {
		int notes = 0;
		boolean flag = false;
		
		for (int i = 0; i < changeArray.length; i++) {
			
			if ((change / changeArray[i]) > 0) {
				notes = change / changeArray[i];
				change = change % changeArray[i];
				changeCounts[i] = changeCounts[i] + notes;
				flag = true;
				break;
			}
		}
		
		if (flag)
			getChange(change, changeCounts,changeArray);
	}

	/**
	 * Returns int of day of week for specific date given
	 * @param day is number of day
	 * @param month is a number of month
	 * @param year is number
	 * @return number of day of week
	 */
	public static int dayOfWeek(int day, int month, int year) {
		float yearo = year - (14 - month) / 12.0f;
		float x = yearo + (yearo / 4) - (yearo / 100) + (yearo / 400);
		float montho = month + 12 * ((14 - month) / 12.0f) - 2;
		float dayo = (day + x + 31 * montho / 12.0f) % 7;
		return (int) dayo;
	}

	/**
	 * Returns temperature in float according to the convertTo char 'F' or 'C'
	 * @param temperature is a number for temperature
	 * @param convertTo is a character 
	 * @return number is a temperature converted
	 */
	public static float temperatureConversion(float temperature, char convertTo) {
		if (convertTo == 'F')
			return (temperature * (9 / 5.0f)) + 32;
		else
			return (temperature - 32) * (5 / 9.0f);
	}

	
	/**
	 * function to calculate monthly payment for given amount, year and rate
	 * @param principal is amount in float
	 * @param year is number of years
	 * @param rate is a number of percentage
	 * @return monthly payment in float
	 */
	public static float monthlyPayment(float principal, float year, float rate) {
		float n = 12 * year;
		float r = rate / (12 * 100);
		return (float) ((principal * r) / (1 - Math.pow((1 + r), -n)));
	}


	/**
	 * function to calculate square root of a number
	 * @param number for which square root is calculated
	 * @return number value of square root
	 */
	public static float sqrt(int number) {
		float t = number;
		while (Math.abs(t - (number / t)) > (t * 1e-15)) {
			t = average(number / t, t);
		}
		return t;
	}

	
	/**
	 * function to calculate average of two float
	 * @param a is number 
	 * @param b is a number
	 * @return average number for a and b
	 */
	public static float average(float a, float b) {
		return (a + b) / 2;
	}
	
	/**
	 * function to convert decimal into binary
	 * @param number is a decimal number
	 * @return String of binary for number
	 */
	public static String toBinary(int number){
		String binary = toBinaryNumber(number);
		int length = binary.length();
		for (int i = 0; i < 8 - length; i++) {
			binary = '0' + binary;
		}
		return binary;
	}
	
	/**
	 * Return binary of a decimal
	 * @param number is a decimal number
	 * @return String of binary for number
	 */
	public static String toBinaryNumber(int number) {
		String binary = "";
		if ((number / 2) == 0 && (number % 2) == 1) {
			return binary + 1;
		} else {
			int bit = number % 2;
			number = number / 2;
			binary = toBinaryNumber(number) + bit;
			return binary;
		}
	}


	/**
	 * function swaps the nibbles from string binary
	 * @param binary is String of binary
	 * @return String
	 */
	public static String swapNibbles(String binary) {
		String nibble1 = binary.substring(0, 4);
		String nibble2 = binary.substring(4);
		return nibble2 + nibble1;
	}
	

	/**
	 * function check if a given number is a power of two or not
	 * @param integer is number
	 * @return boolean true/false
	 */
	public static boolean isPowerOfTwo(int integer) {
		if (integer == 0)
			return false;
		else {
			
			while (integer != 1) {
				
				if (integer % 2 != 0)
					return false;
				
				integer = integer / 2;
			}
			return true;
		}
	}

	/**
	 * Returns decimal integer from binary
	 * @param binary is a string of binary
	 * @return number after conversion from binary
	 */
	public static int toDecimal(String binary) {
		String reverseBinary = reverse(binary);
		int decimal = 0;
		for (int i = 0; i < reverseBinary.length(); i++) {
			if (reverseBinary.charAt(i) == '1') {
				decimal = decimal + (int) Math.pow(2, i);
			}
		}
		return decimal;
	}


	/**
	 * Function to reverse the string
	 * @param string is an input string to reverse
	 * @return string in reversed
	 */
	public static String reverse(String string) {
		String reverseString = "";
		for(int i=0;i<string.length();i++){
			reverseString = string.charAt(i) + reverseString ;
		}
		return reverseString;
	}
	
	/**
	 * function to write string into a file
	 * @param string which is to be written into the file
	 * @param path is a path of file in string format
	 */
	public static void writeToFile(String string,String path){
		try{
			OutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(string);
			bw.flush();
			bw.close();
		}catch(Exception e){
			System.out.print(e.toString());
		}
	}


	/**
	 * Generates random integer
	 * @return number generated using random function 
	 */
	public static int randomGenerator(int number) {
		Random random = new Random();
		int randomNumber = random.nextInt(number);
		return randomNumber;
	}
	

	/**
	 * Function to check for Prime
	 * 
	 * @param number
	 *            to check prime
	 * @return true if number is prime else false
	 */
	public static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {

			// checks for divisibility
			if (number % i == 0)
				return false;
		}
		return true;
	}
	

	/**
	 * @param input
	 *            is a string
	 * @param one
	 *            is an index number to be swapped
	 * @param two
	 *            is an index number to be swapped
	 * @return string after swapping the given index character
	 */
	public static String charSwap(String input, int one, int two) {
		char temp;
		char[] charArray = input.toCharArray();

		// swapping of characters
		temp = charArray[one];
		charArray[one] = charArray[two];
		charArray[two] = temp;

		return String.valueOf(charArray);
	}
	
	/**
	 * function to generate permutation of string
	 * 
	 * @param input
	 *            is a string
	 * @param start
	 *            is a starting index number of input
	 * @param end
	 *            is an end index number of input
	 */
	public static void permutation(String input, int start, int end) {
		if (start == end) {
			System.out.println(input);
		} else {

			// from first character to end
			for (int i = start; i <= end; i++) {

				// swapping index start and at i
				input = charSwap(input, start, i);

				// finding permutation for new string after swapped
				permutation(input, start + 1, end);

				// again swapping back to same string
				input = charSwap(input, start, i);
			}
		}
	}
	
	/**
	 * function to display two dimensional array
	 * @param arr is a generic two dimensional array
	 */
	public static <E> void display(E[][] arr) {
		PrintWriter pw = new PrintWriter(System.out);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				pw.print(arr[i][j] + " ");
			}
			pw.print("\n");
		}
		pw.flush();
		pw.close();
	}
	
	/**
	 * function to display the tic-tac-toe board
	 * 
	 * @param arr
	 *            contains game board moves
	 */
	public static void displayBoard(char[][] arr) {
		for (int i=0;i<arr.length;i++) {
			if(i== 2)
				System.out.print(" " + arr[i][0] + " | " + arr[i][1] + " | " + arr[i][2]);
			else
				System.out.print("_" + arr[i][0] + "_|_" + arr[i][1] + "_|_" + arr[i][2] + "_");
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	/**
	 * function to check if the player wins column-wise
	 * 
	 * @param arr
	 *            contains game board moves
	 * @param xo
	 *            is a char 'X' or 'O'
	 * @return true if there are three similar chars in column else false
	 */
	public static boolean checkCol(char[][] arr, char xo) {
		for (int i = 0; i < 3; i++) {
			if (arr[0][i] == xo && arr[1][i] == xo && arr[2][i] == xo) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * function to check if the player wins row-wise
	 * 
	 * @param arr
	 *            contains game board moves
	 * @param xo
	 *            is a char 'X' or 'O'
	 * @return true if there are three similar chars in rows else false
	 */
	public static boolean checkRows(char[][] arr, char xo) {
		for (int i = 0; i < 3; i++) {
			if (arr[i][0] == xo && arr[i][1] == xo && arr[i][2] == xo) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * function to check if the player wins diagonally
	 * 
	 * @param arr
	 *            contains game board moves
	 * @param xo
	 *            is a char 'X' or 'O'
	 * @return true if there are three similar chars in diagonal else false
	 */
	public static boolean checkDiag(char[][] arr, char xo) {
		if ((arr[0][0] == xo && arr[1][1] == xo && arr[2][2] == xo)
				|| (arr[0][2] == xo && arr[1][1] == xo && arr[2][0] == xo)) {
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * Checks if given number is distinct from list
	 * @param coupons is a List of integer as coupons
	 * @param couponNumber is a number to check for uniqueness
	 * @return true if couponNumber is unique else false
	 */
	public static boolean isDistinct(List<Integer> coupons, int couponNumber) {
		if (coupons.contains(couponNumber))
			return false;
		return true;
	}
	

	/**
	 * function to get the number of binary search tree for a given number
	 * 
	 * @param number
	 *            is a number of nodes
	 * @return number of binary search tree
	 */
	public static int getNumberOfBST(int number) {
		if (number == 0 || number == 1)
			return 1;
		else {
			int numberOfBST = 0;

			for (int i = 0; i < number; i++)
				numberOfBST = numberOfBST + (getNumberOfBST(i) * getNumberOfBST(number - 1 - i));

			return numberOfBST;
		}
	}
}
