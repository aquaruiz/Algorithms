package combinationsWithoutRepetition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static int[] vector;
	public static int[] set;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int elementMax = Integer.parseInt(scanner.nextLine()); // setCount
		int elementsCount = Integer.parseInt(scanner.nextLine()); // vectorCount
		scanner.close();
	
		set = new int[elementMax];
		
		for (int i = 1; i <= elementMax; i++) {
			set[i - 1] = i;
		}
		
		vector = new int[elementsCount];
		generateCombinations(0, 0);
	}

	private static void generateCombinations(int setIndex, int vectorIndex) {
		if (vectorIndex == vector.length) {
			printVector();
		} else {
			for (int i = setIndex; i < set.length; i++) {
				vector[vectorIndex] = set[i];
				generateCombinations(i + 1, vectorIndex + 1);
			}
		}
	}

	private static void printVector() {
		System.out.println(Arrays.stream(vector).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
