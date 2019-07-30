package sorters;

import java.util.function.Consumer;

import helpers.Helper;

public class InsertionSort <T extends Comparable<T>> implements Consumer<T[]> {

	@Override
	public void accept(T[] arr) {
		int counter = 1;
		
		while (counter < arr.length) {
			int currentIndex = counter;
			
			while (currentIndex > 0 && Helper.isLess(arr[currentIndex], arr[currentIndex - 1])) {
				Helper.swap(arr, currentIndex, currentIndex - 1);
				currentIndex--;
			}
			
			counter++;
		}
	}
}