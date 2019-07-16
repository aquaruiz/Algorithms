package permutationsWithRepetition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static String[] elements;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		elements = scanner.nextLine().split(" ");
		elements = new String[] {"A", "B", "B"};
		scanner.close();
		permutate(0);
	}

	private static void permutate(int index) {
		if (index >= elements.length) {
			System.out.println(Arrays.stream(elements).collect(Collectors.joining(" ")));
		} else {
			permutate(index + 1);
			
			Set<String> used = new HashSet<>();
			used.add(elements[index]);
			
			for (int i = index + 1; i < elements.length; i++) {
				if (!used.contains(elements[i])) {
					used.add(elements[i]);
					swap(index, i);
					permutate(index + 1);
					swap(index, i);
				}
			}
		}
	}

	private static void swap(int index, int i) {
		String temp = elements[index];
		elements[index] = elements[i];
		elements[i] = temp;
	}
}