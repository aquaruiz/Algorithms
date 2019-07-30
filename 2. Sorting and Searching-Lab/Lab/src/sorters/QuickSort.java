package sorters;

import java.util.function.Consumer;

import helpers.Helper;

public class QuickSort <T extends Comparable<T>> implements Consumer<T[]> {

	@Override
	public void accept(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
		
	}

	private void quickSort(T[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int mid = partition(arr, lo, hi);
		quickSort(arr, lo, mid - 1);
		quickSort(arr, mid + 1, hi);
	}

	private int partition(T[] arr, int lo, int hi) {
		T pivot = arr[hi];
		int index = lo;
	
		for (int j = lo; j < hi; j++) {
			if (Helper.isLess(arr[j], pivot)) {
				Helper.swap(arr, index, j);
				index++;
			}
		}
		
		Helper.swap(arr, index, hi);
		return index;
	}
}