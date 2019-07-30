package helpers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Helper {
	public static <T> T[] swap(T[] collection, int from, int to) {
		T temp = collection[from];
		collection[from] = collection[to];
		collection[to] = temp;
		return collection;
	}
	
	public static <T extends Comparable<T>> boolean isLess(T first, T second ) {
		return first.compareTo(second) < 0;
	}
	
	public static <T> void printOutput(T[] arr) {
		System.out.println(
					Arrays
						.stream(arr)
						.map(String::valueOf)
						.collect(Collectors.joining(" ")
					));
	}
}