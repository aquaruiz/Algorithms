package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// quick sort
	public static int[] arr;
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		 
		String[] tempArr = in.readLine().split(" ");
		arr = new int[tempArr.length];
		
		for (int i = 0; i < tempArr.length; i++) {
			arr[i] = Integer.parseInt(tempArr[i]);
		}
		
		sort(0, arr.length - 1);

		StringBuilder sb = new StringBuilder();
		
		for (int string : arr) {
			sb.append(string).append(" ");
		}
		
		System.out.println(sb.toString());
	}

	public static void sort(int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = partition(left, right);
		sort(left, pivot - 1);
		sort(pivot, right);
	}

	private static int partition(int left, int right) {
		int middleElement = arr[(left + right) / 2];
		
		while (left <= right) {
			while (isLess(arr[left], middleElement)) {
				left++;
			}
			
			while (isLess(middleElement, arr[right])) {
				right--;
			}
			
			if (left <= right) {
				swap(left, right);
				
				left++;
				right--;
			}
		}
		
		return left;
	}

	private static boolean isLess(int current, int other) {
		return current < other;
	}

	private static void swap(int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}