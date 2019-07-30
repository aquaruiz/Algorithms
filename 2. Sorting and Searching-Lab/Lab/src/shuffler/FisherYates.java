package shuffler;

import java.util.Random;
import java.util.function.Consumer;

import helpers.Helper;

public class FisherYates <T extends Comparable<T>> implements Consumer<T[]> {

	private static Random random = new Random();
	
	@Override
	public void accept(T[] arr) {
		for (int index = 0; index < arr.length; index++) {
			// choose random next index
			int nextIndex = index + random.nextInt(arr.length - index);
			
			Helper.swap(arr, index, nextIndex);
		}
	}
}