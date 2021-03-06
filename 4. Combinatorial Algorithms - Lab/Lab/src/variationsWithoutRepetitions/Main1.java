package variationsWithoutRepetitions;

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
			
			generateVarsWitouthReps(0, 0);
		} catch (IOException e) {
			System.out.println("Something went wrong ;`(");
		}
	}

	private static void generateVarsWitouthReps(int index, int start) {
		if (index == size) {
			printResult();
		} else {
			for (int i = start; i < arr.length; i++) {
				result[index] = arr[i];
				swap(i, start);
				generateVarsWitouthReps(index + 1, start + 1);
				swap(start, i);
			}
		}
	}

	private static void swap(int first, int second) {
		Character oldCharacter = arr[first];
		arr[first] = arr[second];
		arr[second] = oldCharacter;
	}
	
	private static void printResult() {
		System.out.println(
					Arrays.stream(result)
					.map(String::valueOf)
					.collect(Collectors.joining(" "))
				);
	}
}