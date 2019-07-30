package searchers;

import java.util.function.BiFunction;

public class InterpolationSearch <T extends Comparable<T>> implements BiFunction<T[], T, Integer> {

	@Override
	public Integer apply(T[] arr, T needle) {
		Integer index = interpolateSearch(arr, arr.length, needle);
		return index;
	}

	private Integer interpolateSearch(T[] arr, int size, T needle) {
		int low = 0;
		int high = size - 1;
		int mid;
		
		while ((arr[high] != arr[low]) &&
				(needle.compareTo(arr[low]) >= 0) &&
				(needle.compareTo(arr[high]) <= 0)
				) {

	        mid = low + (((Integer)needle - (Integer)arr[low]) * (high - low) / ((Integer)arr[high] - (Integer)arr[low]));
	        
	        if (arr[mid].compareTo(needle) < 0)
	            low = mid + 1;
	        else if (needle.compareTo(arr[mid]) < 0)
	            high = mid - 1;
	        else
	            return mid;
		}
		
		if (needle.compareTo(arr[low]) == 0) {
			return low;
		}  else {
			return -1;
		}
	}
}