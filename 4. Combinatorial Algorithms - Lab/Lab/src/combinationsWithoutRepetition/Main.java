package combinationsWithoutRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	static Character[] elements;
	static int size;
	static Character[] result;
	
	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Enter your elements: ");
			elements = Arrays.stream(bReader.readLine().split(" "))
					.map(s -> s.charAt(0))
					.toArray(Character[]::new);
			System.out.print("Enter your combination lenght: ");
			size = Integer.parseInt(bReader.readLine());
		} catch (IOException e) {
			System.out.println("Someting went wrong ;`(");
		}
		
		result = new Character[size];
		generateCombWithoutReps(0, 0);
	}

	private static void generateCombWithoutReps(int index, int start) {
		if (index == size) {
			printResult();
		} else {
			for (int i = start; i < elements.length; i++) {
				result[index] = elements[i];
				generateCombWithoutReps(index + 1 , i + 1);
			}
		}
	}
	
	private static void printResult() {
		System.out.println(Arrays.stream(result)
				.map(String::valueOf)
				.collect(Collectors.joining(" "))
			);
	}
}