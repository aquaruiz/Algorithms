package combinationswithRepetition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static int[] arr;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int elementMax = Integer.parseInt(scanner.nextLine());
		int elementsCount = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		arr = new int[elementsCount];
		getAllCombinations(elementMax, 0, 1);
	}

	private static void getAllCombinations(int elementMax, int index, int element) {
		if (index >= arr.length) {
			print();
			return;
		}
		
		for (int i = element; i <= elementMax; i++) {
			arr[index] = i;
			getAllCombinations(elementMax, index + 1, i);
		}
	}

	private static void print() {
		System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

}
