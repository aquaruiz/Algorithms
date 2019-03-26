package reverseArray;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		scanner.close();
		
		reverse(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	private static void reverse(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		reverse(arr, start + 1, end - 1);
	}
}