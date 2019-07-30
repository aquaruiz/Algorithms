package totalSearchImpl;

import java.util.function.BiFunction;

import helpers.Chooser;
import helpers.Reader;

public class Main {

	public static void main(String[] args) {

		System.out.print("Please enter your array for searching in: ");
		Integer[] arr = Reader.readArray();
		
		System.out.print("Please enter your needle: ");
		Integer needle = Reader.readInt();
		
		System.out.print("Enter method for searching ");
		System.out.println("or just enter its number: ");
		System.out.println("// 1. Linear Search 2. Binary Search 3. Interpolation Search //");
		
		String searcherString = Reader.readMethod();
		
		BiFunction<Integer[], Integer, Integer> sorter = Chooser.chooseSearcher(searcherString);
		Integer index = sorter.apply(arr, needle);
		System.out.print("Your needle index is: ");
		System.out.println(index);
	}
}