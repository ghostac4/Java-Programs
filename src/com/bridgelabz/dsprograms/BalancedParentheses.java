/**
 * Purpose : Determines the parenthesis in arithmetic expression are balanced or
 * not
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.dsprograms;

import com.bridgelabz.utility.Stack;
import com.bridgelabz.utility.Utility;

public class BalancedParentheses
{

   public static void main(String[] args)
   {
      Stack<String> stack = new Stack<>();
      Utility utility = new Utility();

      System.out.println("Enter the arithmetic expression :");
      String expression = utility.readLine();

      for (int i = 0; i < expression.length(); i++) {

         if (expression.charAt(i) == '(')
            stack.push(')' + "");
         else if (expression.charAt(i) == ')')
            if (stack.pop() == null) {
               System.out.println("false");
               return;
            }
      }

      System.out.println(stack.isEmpty());

   }

}
