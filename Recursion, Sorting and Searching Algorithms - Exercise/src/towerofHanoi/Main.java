package towerofHanoi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static Deque<String> source;
	private static Deque<String> destination = new LinkedList<>();
	private static Deque<String> spare = new LinkedList<>();
	private static int stepsTaken = 0;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfDisks = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		source = new LinkedList<>();
		
		for (int i = numberOfDisks; i >= 1; i--) {
			source.addLast(String.valueOf(i));
		}
		
		printRods();
		MoveDisks(numberOfDisks, source, destination, spare);
		
		System.out.println(sb.toString());
	}

	private static void MoveDisks(int bottomDisk, Deque<String> source, Deque<String> destination,
			Deque<String> spare) {
		if (bottomDisk == 1) {
			stepsTaken++;
			destination.addLast(source.removeLast());
			sb.append(String.format("Step #%d: Moved disk%n", stepsTaken));
			printRods();
		} else {
			MoveDisks(bottomDisk - 1, source, spare, destination);
			MoveDisks(1, source, destination, spare);
			MoveDisks(bottomDisk - 1, spare, destination, source);
		}
	}

	private static void printRods() {
		sb.append("Source: " + source.stream().collect(Collectors.joining(", "))); // ??
		sb.append(System.lineSeparator());
		sb.append("Destination: " + destination.stream().collect(Collectors.joining(", "))); // ??
		sb.append(System.lineSeparator());
		sb.append("Spare: " + spare.stream().collect(Collectors.joining(", "))); // ??
		sb.append(System.lineSeparator()).append(System.lineSeparator());
	}
}