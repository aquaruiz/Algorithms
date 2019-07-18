package towerOfHanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static ArrayDeque<Integer> source;
	static ArrayDeque<Integer> destination;
	static ArrayDeque<Integer> spare;
	static int steps = 0;
	
	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter tower size: ");
		int size = 0;
		try {
			size = Integer.parseInt(bReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Something went wrong ;`(");
			System.exit(-1);
		}
		
		List<Integer> arr = IntStream.range(1, size + 1)
				.boxed()
				.collect(Collectors.toList());
		Collections.reverse(arr);
		source = arr.stream()
				.collect(Collectors.toCollection(ArrayDeque::new));
		
		destination = new ArrayDeque<>();
		spare = new ArrayDeque<>();
		
		System.out.print("Source: ");
		System.out.println(formatSteak(source));
		System.out.print("Destination: ");
		System.out.println(formatSteak(destination));
		System.out.print("Spare: ");
		System.out.println(formatSteak(spare));
		System.out.println();
		
		move(size, source, destination, spare);
	}

	private static void move(int disk, ArrayDeque<Integer> source, ArrayDeque<Integer> destination,
			ArrayDeque<Integer> spare) {

		if (disk < 1) {
			return;
		}
		// move all to spare peek
		move(disk - 1, source, spare, destination);
		
		destination.addLast(disk);
		source.removeLast();
		
		steps++;
		printStep();
		
		// move all back from spare peek  
		move(disk - 1, spare, destination, source);
	}

	private static void printStep() {
		System.out.println(String.format("Step #%d: Moved disk", 
					steps));
		System.out.print("Source: ");
		System.out.println(formatSteak(source));
		System.out.print("Destination: ");
		System.out.println(formatSteak(destination));
		System.out.print("Spare: ");
		System.out.println(formatSteak(spare));
		
		System.out.println();
	}

	private static String formatSteak(ArrayDeque<Integer> steak) {

		return steak.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", "));
	}

}