/**
 * Purpose : Determines the maximum overshoot time for given deadlines and task completion time
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelab.algorithmprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bridgelab.utility.Utility;

public class TaskScheduling {

	public static void main(String[] args) throws CloneNotSupportedException {
		Utility utility = new Utility();
		System.out.print("\nEnter the Number of tasks : ");
		int tasks = utility.readInt();

		List<Task> taskList = new ArrayList<Task>();

		for (int i = 0; i < tasks; i++) {
			Task task = new Task();
			task.setTaskId(i);
			task.setDeadline(utility.readInt());
			task.setMinutes(utility.readInt());
			taskList.add(task);
		}

		for (Task task : taskList)
			System.out.print("\nTask " + task.getTaskId() + " : " + task.getDeadline());

		System.out.print("\n");

		for (int i = 0; i < tasks; i++) {
			int j = i + 1;
			List<Task> list = new ArrayList<>();
			inner: for (Task task : taskList) {
				if (j == 0)
					break inner;
				Task taskClone = (Task) task.clone();
				list.add(taskClone);
				j--;
			}
			System.out.print("\n"+getOvershoot(list));
		}
	}
	
	public static int getOvershoot(List<Task> taskList) {
		Collections.sort(taskList);

		int index = 0, time = 1;
		int max = 0;
		while (!taskList.isEmpty()) {
			Task task;
			if (taskList.size() == 1) {
				task = taskList.get(0);
				task.setMinutes(task.getMinutes() - 1);
				//System.out.print("\nTime " + time + " : Task" + task.taskId);
				if (task.getMinutes() == 0) {
					int tempMax = time - task.getDeadline();
					if (tempMax > max)
						max = tempMax;
					taskList.remove(0);
				}
				time++;
			} else {
				if (index >= taskList.size() - 1) {
					index = 0;
				} else {
					task = taskList.get(index);
					if (task.getDeadline() > time && time != 1) {
						index = 0;
					} else {
						task.setMinutes(task.getMinutes() - 1);
						//System.out.print("\nTime " + time + " : Task" + task.taskId);
						if (task.getMinutes() == 0) {
							int tempMax = time - task.getDeadline();
							if (tempMax > max)
								max = tempMax;
							taskList.remove(index);
						}
						time++;
						index++;
					}
				}
			}
		}
		return max;
	}
}
