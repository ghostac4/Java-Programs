/**
 * Purpose : Displays calender for a given month and year
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.dsprograms;

import java.util.Arrays;
import java.util.Calendar;

import com.bridgelab.utility.Queue;
import com.bridgelab.utility.Stack;

public class Calender {

	public static void main(String[] args) {
		String[] weekDays = { "S", "M", "T", "W", "Th", "F", "Sa" };
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] monthsDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		int dayOfWeek;
		String[][] calender = new String[6][7];

		for (String[] calenderRow : calender)
			Arrays.fill(calenderRow, "  ");

		String monthString = "";
		int monthDays = 0, days = 0;

		if (month == 2)
			if (year % 4 == 0)
				if(year % 100 == 0)
					if(year % 400 == 0)
						monthDays = 29;
					else
						monthDays = monthsDays[month-1];
				else
					monthDays = 29;
			else
				monthDays = monthsDays[month - 1];
		else
			monthDays = monthsDays[month - 1];

		monthString = months[month - 1];

		System.out.print("\n*****" + monthString + "-" + year + "*****");
		System.out.print("\n S  M  T  W Th  F  S\n");
		Calendar calendar = Calendar.getInstance();

		calendar.set(year, month - 1, 1);
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		outer: for (int i = 0; i < 6; i++) {
			int j;
			if (i == 0)
				j = dayOfWeek;
			else
				j = 0;
			for (; j < 7; j++) {
				days++;
				if (days < 10)
					calender[i][j] = " " + days;
				else
					calender[i][j] = days + "";
				if (days == monthDays)
					break outer;
			}
		}
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 7; j++)
				System.out.print(calender[i][j] + " ");
		System.out.print("\n");
		}	
		
		Queue<Queue<WeekDay>> weekQueue = new Queue<>();
		for (int i = 0; i < 6; i++) {
			Queue<WeekDay> weekDayQueue = new Queue<>();
			for (int j = 0; j < 7; j++) {
				WeekDay weekDay = new WeekDay();
				weekDay.setDate(calender[i][j]);
				weekDay.setDay(weekDays[j]);
				weekDayQueue.enqueue(weekDay);
			}
			weekQueue.enqueue(weekDayQueue);
		}

		// Question 9 : The WeekDay objects are stored in a Queue implemented
		// using Linked List.
		System.out.print("\nCalendar ----- Queue using Linked List --------");

		System.out.print("\n*****" + monthString + "-" + year + "*****");
		System.out.print("\n S  M  T  W Th  F  S\n");
		for (int i = 0; i < 6; i++) {
			Queue<WeekDay> weekDayQueue = weekQueue.dequeue();
			for (int j = 0; j < 7; j++) {
				WeekDay weekDay = weekDayQueue.dequeue();
				System.out.print(weekDay.getDate() + " ");
			}
			System.out.print("\n");
		}

		// Question 10 : program to store the Queue in two Stacks. Stack here is
		// also implemented using Linked List
		System.out.print("\nCalendar ----- Queue in Stack --------");

		Stack<Queue<WeekDay>> stack1 = new Stack<>();
		for (int i = 0; i < 6; i++) {
			Queue<WeekDay> weekDayQueue = new Queue<>();
			for (int j = 0; j < 7; j++) {
				WeekDay weekDay = new WeekDay();
				weekDay.setDate(calender[i][j]);
				weekDay.setDay(weekDays[j]);
				weekDayQueue.enqueue(weekDay);
			}
			stack1.push(weekDayQueue);
		}

		Stack<Queue<WeekDay>> stack2 = new Stack<>();
		for (int i = 0; i < 6; i++)
			stack2.push(stack1.pop());

		System.out.print("\n*****" + monthString + "-" + year + "*****");
		System.out.print("\n S  M  T  W Th  F  S\n");
		
		for (int i = 0; i < 6; i++) {
			Queue<WeekDay> weekDayQueue = stack2.pop();
			for (int j = 0; j < 7; j++) {
				WeekDay weekDay = weekDayQueue.dequeue();
				System.out.print(weekDay.getDate() + " ");
			}
			System.out.print("\n");
		}
	}
}
