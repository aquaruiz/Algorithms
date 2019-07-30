package helpers;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import searchers.BinarySearch;
import searchers.InterpolationSearch;
import searchers.LinearSearch;
import shuffler.FisherYates;
import sorters.BubbleSort;
import sorters.BucketSort;
import sorters.CountingSort;
import sorters.InsertionSort;
import sorters.MergeSort;
import sorters.QuickSort;
import sorters.SelectionSort;

public class Chooser {
	public static <T extends Comparable<T>> BiFunction<T[], T, Integer> chooseSearcher(String searcherName) {
		switch (searcherName) {
		case "linear":
		case "lineary":
		case "linearsearch":
		case "linear search":
		case "1":
			return new LinearSearch<>();
		case "binary":
		case "binarysearch":
		case "binary search":
		case "2":
			return new BinarySearch<>();
		case "interpolation":
		case "interpolationsearch":
		case "interpolation search":
		case "3":
			return new InterpolationSearch<>();
		default:
			return null;
		}
	}
	
	public static <T extends Comparable<T>> Consumer<T[]> chooseMethod(String methodName) {
		switch (methodName) {
		case "selection":
		case "selectionsort":
		case "selection sort":
		case "1":
			return new SelectionSort<>();
		case "bubble":
		case "bubblesort":
		case "bubble sort":
		case "2":
			return new BubbleSort<>();
		case "insertion":
		case "insertionsort":
		case "insertion sort":
		case "3":
			return new InsertionSort<>();
		case "fisher":
		case "fisheryates":
		case "fisher yates":
		case "fisher-yates":
		case "4":
			return new FisherYates<>();
		case "merge":
		case "mergesort":
		case "merge sort":
		case "5":
			return new MergeSort<>();
		case "quick":
		case "quicksort":
		case "quick sort":
		case "6":
			return new QuickSort<>();
		case "counting":
		case "countingsort":
		case "counting sort":
		case "7":
			return new CountingSort<>();
		case "bucket":
		case "bucketsort":
		case "bucket sort":
		case "8":
			return new BucketSort<>();
		default:
			return null;
		}
	}
}