package towerofHanoi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static Deque<Integer> source;
	private static Deque<Integer> destination = new ArrayDeque<>();
	private static Deque<Integer> spare = new ArrayDeque<>();
	private static int stepsTaken = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfDisks = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		source = new ArrayDeque<>();
		
		for (int i = numberOfDisks; i >= 1; i--) {
			source.push(i);
		}
		
		printRods();
		MoveDisks(numberOfDisks, source, destination, spare);
	}

	private static void MoveDisks(int bottomDisk, Deque<Integer> source, Deque<Integer> destination,
			Deque<Integer> spare) {
		if (bottomDisk == 1) {
			stepsTaken++;
			destination.push(source.pop());
			System.out.println(String.format("Step #%d: Moved disk", stepsTaken));
			printRods();
		} else {
			MoveDisks(bottomDisk - 1, source, spare, destination);
			stepsTaken++;
			destination.push(source.pop());
			System.out.println(String.format("Step #%d: Moved disk", stepsTaken));
			printRods();
			MoveDisks(bottomDisk - 1, spare, destination, source);
		}
	}

	private static void printRods() {
		System.out.println("Source: " + source.stream().map(String::valueOf).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining(", "))); // ??
		System.out.println("Destination: " + destination.stream().map(String::valueOf).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining(", "))); // ??
		System.out.println("Spare: " + spare.stream().map(String::valueOf).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining(", "))); // ??
		System.out.println();
	}

}