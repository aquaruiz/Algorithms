package bubbleSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {2, 5, 1, 9, 73, 7, 3, 5, 10, 1};
		
		bubbleSort(arr);

		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int placedCorrectlyElements = 0;
		while (!isSorted(arr)) {
			for (int i = 1; i < arr.length - placedCorrectlyElements; i++) {
				if (isMore(arr[i - 1], arr[i])) {
					swap(arr, i, i - 1);
				}
			}

			placedCorrectlyElements++;
		}
	}
	
	public static <T> void swap(T[] arr, int from, int to) {
		T temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
	
	public static <T extends Comparable<T>> boolean isLess(T first, T second) {
		return first.compareTo(second) < 0;
	}
	
	public static <T extends Comparable<T>> boolean isMore(T first, T second) {
		return first.compareTo(second) > 0;
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (isMore(arr[i - 1], arr[i])) {
				return false;
			}
		}
		
		return true;
	}
}