package selectionSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {2, 5, 1, 9, 7, 3, 5, 10, 1};
		
		selectionSort(arr);

		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = findMinIndex(arr, i);
			swap(arr, minIndex, i);
		}
	}
	
	private static <T extends Comparable<T>> int findMinIndex(T[] arr, int border) {
		int minIndex = border;
		T min = arr[border];
		
		for (int i = border; i < arr.length; i++) {
			if (isLess(arr[i], min)) {
				min = arr[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}

	public static <T> void swap(T[] arr, int from, int to) {
		T temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
	
	public static <T extends Comparable<T>> boolean isLess(T first, T second) {
		return first.compareTo(second) < 0;
	}
}