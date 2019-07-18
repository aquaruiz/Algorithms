package variationsWithRepetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main1 {
	static Character[] arr;
	static int size = 0;
	static Character[] result;
	
	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Enter your initial array: ");
			arr = Arrays.stream(bReader
					.readLine()
					.split(" "))
					.map(a -> a.charAt(0))
					.toArray(Character[]::new);
			System.out.print("Enter new arr size: ");
			size = Integer.parseInt(bReader.readLine());
			result = new Character[size];
			
			generateVarsWitouthReps(0);
		} catch (IOException e) {
			System.out.println("Something went wrong ;`(");
		}
	}

	private static void generateVarsWitouthReps(int index) {
		if (index == size) {
			printResult();
		} else {
			for (int i = 0; i < arr.length; i++) {
				result[index] = arr[i];
				generateVarsWitouthReps(index + 1);
			}
		}
	}

	private static void printResult() {
		System.out.println(
					Arrays.stream(result)
					.map(String::valueOf)
					.collect(Collectors.joining(" "))
				);
	}
}