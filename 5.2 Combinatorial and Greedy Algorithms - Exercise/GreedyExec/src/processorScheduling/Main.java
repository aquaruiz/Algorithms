package processorScheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static List<Task> allTasks = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int tasksCount = Integer.parseInt(bReader.readLine().substring(7));
		
		for (int i = 0; i < tasksCount; i++) {
			String[] input = bReader.readLine().split(" - ");
			int value = Integer.parseInt(input[0]);
			int deadline = Integer.parseInt(input[1]);
			Task currentTask = new Task(value, deadline);
			allTasks.add(currentTask);
		}
		
		List<Task> choosenTasks = chooseHighPriority();
		System.out.println("Optimal schedule: " + choosenTasks.stream()
								.map(t -> String.format("%d", t.getNumber()))
								.collect(Collectors.joining(" -> ")));
		System.out.println("Total value: " + 
								choosenTasks.stream()
									.mapToInt(Task::getValue)
									.sum()
							);
	}
	
	private static List<Task> chooseHighPriority() {
		List<Task> choosen = new ArrayList<>();
		
		int maxDeadline = allTasks
								.stream()
								.max((a, b) -> a.getDeadline() - b.getDeadline())
								.get()
								.getDeadline();
		
		for (int i = 0; i < maxDeadline; i++) {
			final int f = i;
			List<Task> mostValuableTasks = allTasks.stream()
					.filter(t -> !t.isCompleted && t.deadline > f) // remove all finished and all overdue
					.collect(Collectors.toCollection(ArrayList<Task>::new));
			
			Collections.sort(mostValuableTasks, new TaskValueComp(i)); // sort

			mostValuableTasks.get(0).setCompleted(true);
			choosen.add(mostValuableTasks.get(0));
		}
		
		return choosen;
	}

	static class Task {
		private static int counter = 1;
		private int number;
		private int value;
		private int deadline;
		private boolean isCompleted;
		
		public Task(int value, int deadline) {
			this.setNumber();
			setValue(value);
			setDeadline(deadline);
			setCompleted(false);
		}
		
		public int getValue() {
			return value;
		}
		
		public int getDeadline() {
			return deadline;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
		
		public void setDeadline(int deadline) {
			this.deadline = deadline;
		}
		
		@Override
		public String toString() {
			return String.format("%d. %d -> %d", 
					getNumber(),
					getValue(),
					getDeadline());
		}

		public int getNumber() {
			return this.number;
		}

		public void setNumber() {
			this.number = counter++;
		}
		
		public boolean isCompleted() {
			return isCompleted;
		}

		public void setCompleted(boolean isCompleted) {
			this.isCompleted = isCompleted;
		}
		
		public int getRatio(int currentDeadline) {
			return (int)(value / (double) (deadline - currentDeadline));
		}
	}
	
	static class TaskValueComp implements Comparator<Task>{
		private int currentDeadline;
		
		public TaskValueComp(int currentDeadline) {
			this.currentDeadline = currentDeadline;
		}

		@Override
		public int compare(Task t1, Task t2) {
			return (int)(t2.getRatio(currentDeadline) - t1.getRatio(currentDeadline));
		}
	}
}