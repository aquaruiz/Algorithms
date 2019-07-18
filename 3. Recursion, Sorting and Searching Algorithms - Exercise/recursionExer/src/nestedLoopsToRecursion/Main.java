package nestedLoopsToRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter your num: ");
		int num = 0;
		
		try {
			num = Integer.parseInt(bReader.readLine());
			int[] arr = new int[num];
			makeNestedLoops(arr, 0);
			
		} catch (NumberFormatException | IOException e) {
			System.out.println("something went wrong ;`(");
		}
	}

	private static void makeNestedLoops(int[] arr, int num) {
		if (num == arr.length) {
			System.out.println(
						Arrays.stream(arr)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(" "))
					);
			return;
		}
		
		for (int i = 1; i <= arr.length; i++) {
			arr[num] = i;
			makeNestedLoops(arr, num + 1); 
		}
	}

}