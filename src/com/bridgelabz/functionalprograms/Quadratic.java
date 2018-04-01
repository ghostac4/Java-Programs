
/**
 * Purpose : Finds the roots of quadratic equation
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */

package com.bridgelab.functionalprograms;

import com.bridgelab.utility.Utility;

public class Quadratic {

	public static void main(String args[]) {
		Utility utility = new Utility();
		System.out.println("Enter the value of a :");
		int a = utility.readInt();
		System.out.println("Enter the value for b :");
		int b = utility.readInt();
		System.out.println("Enter the value for c :");
		int c = utility.readInt();
		
		//calculates : delta = b*b - 4*a*c
		double delta = Math.pow(b, 2) - 4 * a * c;
		
		if(delta < 0)
			System.out.println("The given Quadratice Equation has no Real Roots");
		else if(delta == 0){
			//calculates root 1 : x = (-b + sqrt(delta))/(2*a)
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
			
			System.out.println("The given Quadratice Equation has only one root : "+x1);
		}else{
			//calculates root 1 : x = (-b + sqrt(delta))/(2*a)
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
			
			//calculates root 2 : x = (-b - sqrt(delta))/(2*a)
			double x2 = (-b - Math.sqrt(delta)) / (2 * a);
			
			System.out.println("The given Quadratice Equation has only one root : "+x1+" and "+x2);
		}
	}
}
