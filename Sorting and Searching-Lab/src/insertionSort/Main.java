package insertionSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {2, 5, 1, 9, 73, 7, 3, 5, 10, 1};
		
		insertionSort(arr);

		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int prevIdx = i -1;
			int currIdx = i;
			
			while (prevIdx >= 0
					&& isMore(arr[prevIdx], arr[currIdx])) {
				swap(arr, currIdx, prevIdx);
				prevIdx--;
				currIdx--;
			}
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