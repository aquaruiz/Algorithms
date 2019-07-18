package combinationsWithRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter your max num: ");
		int maxNum = 0;
		int size = 0;
		
		try {
			maxNum = Integer.parseInt(bReader.readLine());
			System.out.print("Please enter your combination size: ");
			size = Integer.parseInt(bReader.readLine());
			
			int[] arr = new int[size];
			makeCombWithRepetition(arr, 0, maxNum, 1);
			
		} catch (NumberFormatException | IOException e) {
			System.out.println("something went wrong ;`(");
		}
	}

	private static void makeCombWithRepetition(int[] arr, int num, int max, int border) {
		if (num == arr.length || border == max + 1) {
			System.out.println(
						Arrays.stream(arr)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(" "))
					);
			return;
		}
		
		for (int i = border; i <= max; i++) {
			arr[num] = i;
			makeCombWithRepetition(arr, num + 1, max, i); 
		}
	}

}