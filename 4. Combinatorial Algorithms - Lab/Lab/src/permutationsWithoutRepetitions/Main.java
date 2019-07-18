package permutationsWithoutRepetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	static Character[] arr;
	
	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Enter your array: ");
			arr = Arrays.stream(bReader
					.readLine()
					.split(" "))
					.map(a -> a.charAt(0))
					.toArray(Character[]::new);
			
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
		
		generatePermsWithoutReps(index + 1);
		
		for (int i = index + 1; i < arr.length; i++) {
			swap(index, i);
			generatePermsWithoutReps(index + 1);
			swap(i, index);
		}
	}
	
	private static void swap(int index, int i) {
		Character oldCharacter = arr[index];
		arr[index] = arr[i];
		arr[i] = oldCharacter;
	}

	private static void printResult() {
		System.out.println(Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining(" ")));
	}
}