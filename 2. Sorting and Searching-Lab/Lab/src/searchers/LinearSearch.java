package searchers;

import java.util.function.BiFunction;


public class LinearSearch <T extends Comparable<T>> implements BiFunction<T[], T, Integer> {

	@Override
	public Integer apply(T[] arr, T needle) {
		int index = - 1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == needle) {
				index = i;
				break;
			}
		}
		
		return index;
	}
}
