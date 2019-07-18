package permutationsWithoutRepetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
	static Character[] arr;
	static Character[] output;
	static List<Character> used;
	
	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Enter your array: ");
			arr = Arrays.stream(bReader
					.readLine()
					.split(" "))
					.map(a -> a.charAt(0))
					.toArray(Character[]::new);
			output = new Character[arr.length];
			used = new ArrayList<>();
			
			generatePermsWithoutReps(0);
		} catch (IOException e) {
			System.out.println("Something went wrong ;`(");
		}
	}

	private static void generatePermsWithoutReps(int index) {
		if (index == arr.length) {
			printResult();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!used.contains(arr[i])) {
				used.add(arr[i]);
				output[index] = arr[i];
				generatePermsWithoutReps(index + 1);
				used.remove(arr[i]);
			}
		}		
	}
	
	private static void printResult() {
		System.out.println(Arrays.stream(output).map(String::valueOf).collect(Collectors.joining(" ")));
	}
}