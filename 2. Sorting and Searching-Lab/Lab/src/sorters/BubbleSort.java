package sorters;

import java.util.function.Consumer;

import helpers.Helper;

public class BubbleSort <T extends Comparable<T>> implements Consumer<T[]> {

	@Override
	public void accept(T[] arr) {
		boolean haveSwap = true;
		
		while (haveSwap) {
			haveSwap = false;
			
			for (int i = 1; i < arr.length; i++) {
				if (Helper.isLess(arr[i], arr[i - 1])) {
					Helper.swap(arr, i, i - 1);
					haveSwap = true;
				}
			}
		}
	}
}