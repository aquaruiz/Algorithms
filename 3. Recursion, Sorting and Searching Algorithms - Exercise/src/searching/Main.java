package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();
		int key = Integer.parseInt(in.readLine());
		
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