package sorters;

import java.util.function.Consumer;

import helpers.Helper;

public class SelectionSort <T extends Comparable<T>> implements Consumer<T[]>{

	@Override
	public void accept(T[] arr) {
		for (int index = 0; index < arr.length; index++) {
			int minIndex = index;
			
			for (int current = index + 1; current< arr.length; current++) {
				if (Helper.isLess(arr[current], arr[minIndex])) {
					minIndex = current;
				}
			}
			
			Helper.swap(arr, index, minIndex);
		}
		
	}

}