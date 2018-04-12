/**
 * Purpose : Temperature conversion from fahrenheit to celsuis and vice versa
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class TemperatureConversion {

	public static void main(String[] args) {
		Utility utility = new Utility();
		
		System.out.println("                    1.Celsuis To Fahrenheit");
		System.out.println("                    2.Fahrenheit To Celsuis");
		System.out.println("Enter Your Choice : ");
		int choice = utility.readInt();

		switch (choice) {
		case 1:
			System.out.println("Enter the Temperature in Celsuis : ");
			float temperature = utility.readFloat();
			temperature = Utility.temperatureConversion(temperature, 'F');
			System.out.println("Fahrenheit : " + temperature+" F");
			break;
		case 2:
			System.out.println("Enter the Temperature in Fahrenheit: ");
			temperature = utility.readFloat();
			temperature = Utility.temperatureConversion(temperature, 'C');
			System.out.println("Celsuis : " + temperature+" C");
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}

}
