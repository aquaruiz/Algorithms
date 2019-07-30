package sorters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BucketSort <T extends Comparable<T>> implements Consumer<T[]> {
	private final int BUCKETS_COUNT = 10;
	private final int MAX_ELEMENT = 100;

	@SuppressWarnings("unchecked")
	private final List<T>[] BUCKETS = (List<T>[]) Array.newInstance(List.class, BUCKETS_COUNT);
	
	@SuppressWarnings("unchecked")
	@Override
	public void accept(T[] arr) {
		for (int i = 0; i < BUCKETS.length; i++) {
			BUCKETS[i] = new ArrayList<T>();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int double1 = (int) arr[i];
			BUCKETS[(int) (BUCKETS_COUNT * double1 / MAX_ELEMENT)].add(arr[i]);
		}

		int index = 0;
		
		for (List<T> list: BUCKETS) {
			Consumer sorter = new MergeSort<>();
			Comparable<T>[] sorted = list.stream().toArray(Comparable[]::new);
			sorter.accept(sorted);
			
			for (int i = 0; i < sorted.length; i++) {
				arr[index] = (T) sorted[i];
				index++;
			}
		}
	}
}