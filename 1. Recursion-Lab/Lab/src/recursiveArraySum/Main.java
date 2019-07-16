package recursiveArraySum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = null;
		System.out.print("Enter your array: (e.d 1 2 3 4): ");
		try {
			arr = Arrays.stream(bReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} catch (IOException e) {
			System.out.println("Something went wrong :`(");
		}

		int sum = sumArray(arr, 0);
		System.out.println(sum);
	}

	private static int sumArray(int[] arr, int index) {
		if (index == arr.length) {
			return 0;
		}
		
		return arr[index] + sumArray(arr, index + 1);
	}
}