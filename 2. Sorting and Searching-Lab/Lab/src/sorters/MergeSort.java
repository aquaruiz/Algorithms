package sorters;

import java.lang.reflect.Array;
import java.util.function.Consumer;

import helpers.Helper;

public class MergeSort <T extends Comparable<T>> implements Consumer<T[]> {
	private T[] auxArr;
	private T[] arr;
	
	@SuppressWarnings("unchecked")
	@Override
	public void accept(T[] arr) {
		this.arr = arr;
		this.auxArr = (T[]) Array.newInstance(Comparable.class, arr.length);
		
		sort(0, arr.length - 1);
	}

	private void sort(int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		
		sort(lo, mid);
		sort(mid + 1, hi);
		merge(lo, mid, hi);	
	}

	private void merge(int lo, int mid, int hi) {
		
		if (Helper.isLess(arr[mid], arr[mid + 1])) {
			return;
		}
	
		for (int index = lo; index < hi + 1; index++) {
			auxArr[index] = arr[index];
		}
	
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = auxArr[j++];
			} else if (j > hi) {
				arr[k] = auxArr[i++];
			} else if (Helper.isLess(auxArr[i], auxArr[j])) {
				arr[k] = auxArr[i++];
			} else {
				arr[k] = auxArr[j++];
			}
		}		
	}
}