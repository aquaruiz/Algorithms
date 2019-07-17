package generatingCombinations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main0 {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = null;
		int size = 0;
		
		try {
			System.out.print("Enter your num array: ");
			arr = Arrays.stream(bReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			System.out.print("Enter size of your combination: ");
			size = Integer.parseInt(bReader.readLine());
		} catch (Exception e) {
			System.out.println("Something went wrong ;`(");
		}

		int[] combArr = new int[size];
		calcAllCombs(arr, 0, combArr);
	}

	private static void calcAllCombs(int[] arr, int index, int[] combArr) {
		if (index == combArr.length) {
			System.out.println(Arrays.stream(combArr).mapToObj(String::valueOf).collect(Collectors.joining("")));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			combArr[index] = arr[i];
			calcAllCombs(arr, index + 1, combArr);
		}
		
	}

}