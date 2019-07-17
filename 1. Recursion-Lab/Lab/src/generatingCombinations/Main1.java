package generatingCombinations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main1 {
	static int[] arr = null;
	static int[] combArr;
	
	public static void main(String[] args) {
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int size = 0;
		
		try {
			System.out.print("Enter your num array: ");
			arr = Arrays.stream(bReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			System.out.print("Enter size of your combination: ");
			size = Integer.parseInt(bReader.readLine());
		} catch (Exception e) {
			System.out.println("Something went wrong ;`(");
		}

		combArr = new int[size];
		calcAllCombs(0, 0);
	}

	private static void calcAllCombs(int index, int start) {
		if (index == combArr.length) {
			System.out.println(Arrays.stream(combArr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			combArr[index] = arr[i];
			calcAllCombs(index + 1, i + 1);
		}
		
	}

}