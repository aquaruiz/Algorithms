package searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int key = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		if (input.isEmpty()) {
			return;
		}
		
		int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		int index = indexOf(arr, key);
		
		System.out.println(index);
	}

	public static int indexOf(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if (key < arr[mid]) {
				hi = mid - 1;
			} else if (key > arr[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
}