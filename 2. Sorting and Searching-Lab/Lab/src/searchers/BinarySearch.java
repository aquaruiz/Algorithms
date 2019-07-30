package searchers;

import java.util.function.BiFunction;

public class BinarySearch <T extends Comparable<T>> implements BiFunction<T[], T, Integer> {

	@Override
	public Integer apply(T[] arr, T needle) {
		Integer index = binarySearch(arr, needle, 0, arr.length - 1);
		return index;
	}

	private Integer binarySearch(T[] arr, T needle, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		if (arr[mid].compareTo((T) needle) > 0 ) {
			return binarySearch(arr, needle, start, mid - 1);
		} else if (arr[mid].compareTo(needle) < 0) {
			return binarySearch(arr, needle, mid + 1, end);
		} else {
			return mid;
		}
	}
}