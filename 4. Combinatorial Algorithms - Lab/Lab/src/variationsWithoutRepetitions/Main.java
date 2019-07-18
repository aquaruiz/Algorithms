package variationsWithoutRepetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static Character[] arr;
	static int size = 0;
	static List<Character> used;
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
			used = new ArrayList<>();
			
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
				if (!used.contains(arr[i])) {
					result[index] = arr[i];
					used.add(arr[i]);
					generateVarsWitouthReps(index + 1);
					used.remove(arr[i]);
				}
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