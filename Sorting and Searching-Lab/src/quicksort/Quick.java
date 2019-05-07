package quicksort;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class Quick {
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length - 1);
	}


	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int pivot = partition(a, lo, hi);
		sort(a, lo, pivot - 1);
		sort(a, pivot + 1, hi);
	}

	@SuppressWarnings("unchecked")
	private static int partition(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return lo;
		}
		
		int i = lo;
		int j = hi + 1;
		
		while (true) {
			while (less(a[++i], a[lo])) {
				if (i == hi) {
					break;
				}
			}
			
			while (less(a[lo], a[--j])) {
				if (j == lo) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			
			swap(a, i, j);
		}
		
		swap(a, lo, j);
		return j;
	}

	private static void shuffle(Comparable[] source) {
		Random random = new Random();
		
		for (int i = 0; i < source.length; i++) {
			int r = random.nextInt(source.length - 1); // ??
			Comparable temp = source[i];
			source[i] = source[r];
			source[r] = temp;
		}
	}

	private static <T extends Comparable<T>>boolean less(T current, T other) {
		return current.compareTo(other) < 0;
	}

	private static void swap(Comparable[] a, int first, int second) {
		Comparable temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
}