package reverseArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter your array: ");
		int[] arr = null;
		try {
			arr = Arrays.stream(bReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int[] reversedArr = reverseArray(arr);
			
			System.out.println(
						Arrays.stream(reversedArr)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(" "))
					);
		} catch (IOException e) {
			System.out.println("something went wrong ;`(");
		}
	}

	private static int[] reverseArray(int[] arr) {
		int[] newRevArr = Arrays.copyOf(arr, arr.length);
		
		reverseArray(newRevArr, 0);
		return newRevArr;
	}

	private static void reverseArray(int[] newRevArr, int i) {
		if (i == (int) newRevArr.length / 2) {
			return;
		}
		
		int old = newRevArr[i];
		newRevArr[i] = newRevArr[newRevArr.length - 1 - i];
		newRevArr[newRevArr.length - 1 - i] = old;
		reverseArray(newRevArr, i + 1);
	}

}