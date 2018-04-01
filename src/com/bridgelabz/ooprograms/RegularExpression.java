/**
 * Purpose : Demonstration of regular expression
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelab.ooprograms;

<<<<<<< HEAD
import java.util.StringJoiner;
=======
>>>>>>> 6ff2e49dee84fda0207c9e636b33c60a3647c493
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelab.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String input = "Hello <<name>>, We have your full name as <<full name>> in our system. "
				+ "your contact number is 91-xxxxxxxxxx. Please,let us know in case of any "
				+ "clarification Thank you BridgeLabz 01/01/2016.";
		String[] patterns = { "<{2}\\w+>{2}", "<{2}\\w+\\s\\w+>{2}", "x{10}", "\\d+[/]\\d+[/]\\d+" };
		System.out.print("\nEnter your Name :");
		String name = utility.readLine();
		System.out.print("\nEnter your Full Name :");
		String fullName = utility.readLine();
		System.out.print("\nEnter your Mobile Number :");
		String mobileNumber = utility.readLine();
		System.out.print("\nEnter todays Date :");
		String date = utility.readLine();
		
		String[] dateSplit = date.split("[-/\\s.]");
		StringJoiner stringJoiner = new StringJoiner("/");
		stringJoiner.add(dateSplit[0]);
		stringJoiner.add(dateSplit[1]);
		stringJoiner.add(dateSplit[2]);
		
		date = stringJoiner.toString();
		String[] replace = { name, fullName, mobileNumber, date };
		String output = input;
		for (int i = 0; i < patterns.length; i++) {
			Pattern pattern = Pattern.compile(patterns[i]);
			Matcher matcher = pattern.matcher(output);

			while (matcher.find()) {
				output = matcher.replaceAll(replace[i]);
			}
		}
		System.out.print("\n" + output);
	}

}
