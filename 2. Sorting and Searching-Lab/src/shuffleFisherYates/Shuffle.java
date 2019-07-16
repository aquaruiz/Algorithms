package shuffleFisherYates;

import java.util.Random;

public class Shuffle {
	public static <T> void FisherYates(T[] arr) {
		int collectionLength = arr.length;
		Random random = new Random();

		for (int i = 0; i < arr.length - 1; i++) {
			int randomIdx = random.ints(1, i + 1, collectionLength).findFirst().orElse(i);
			swap(arr, i, randomIdx);
		}
	}
	
	public static <T> void swap(T[] arr, int from, int to) {
		T temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
	
}
