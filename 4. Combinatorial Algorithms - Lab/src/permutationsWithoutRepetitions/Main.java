package permutationsWithoutRepetitions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static String[] elements;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		elements = scanner.nextLine().split(" ");
//		elements = new String[] {"A", "B", "C"};
		scanner.close();
		permutate(0);
	}

	private static void permutate(int index) {
		if (index >= elements.length) {
			System.out.println(Arrays.stream(elements).collect(Collectors.joining(" ")));
		} else {
			permutate(index + 1);
			
			for (int i = index + 1; i < elements.length; i++) {
					swap(index, i);
					permutate(index + 1);
					swap(index, i);
			}
		}
	}

	private static void swap(int index, int i) {
		String temp = elements[index];
		elements[index] = elements[i];
		elements[i] = temp;
	}
}