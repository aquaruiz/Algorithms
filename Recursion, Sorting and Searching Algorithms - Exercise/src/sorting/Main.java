package sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static int[] tempArr;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		scanner.close();
		
		sort(arr);
		System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	private static void sort(int[] arr) {
		tempArr = new int[arr.length];
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		sort(arr, lo, mid);
		sort(arr, mid + 1, hi);
		merge(arr, lo, mid, hi);
	}

	private static void merge(int[] arr, int lo, int mid, int hi) {
		if (isLess(arr[mid], arr[mid + 1])) {
			return;
		}
		
		for (int i = lo; i < hi + 1; i++) {
			tempArr[i] = arr[i];
		}
		
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = tempArr[j];
				j++;
			} else if (j > hi) {
				arr[k] = tempArr[i];
				i++;
			} else if (isLess(tempArr[i], tempArr[j])) {
				arr[k] = tempArr[i];
				i++;
			} else {
				arr[k] = tempArr[j];
				j++;
			}
		}
	}

	private static boolean isLess(int current, int other) {
		return current < other;
	}
}