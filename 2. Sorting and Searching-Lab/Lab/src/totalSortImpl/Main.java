package totalSortImpl;

import java.util.function.Consumer;

import helpers.Chooser;
import helpers.Helper;
import helpers.Reader;

public class Main {

	public static void main(String[] args) {

		System.out.print("Please enter your array for sorting: ");
		Integer[] arr = Reader.readArray();
		
		System.out.print("Enter method for sorting ");
		System.out.println("or just enter its number: ");
		System.out.println("// 1. Selection Sort 2. Bubble Sort 3. Insertion Sort 4. Fisher Yates Randomization " + 
				"5. Merge Sort 6. Quick Sort 7. Counting Sort 8. Bucket Sort //");
		
		String methodString = Reader.readMethod();
		
		Consumer<Integer[]> sorter = Chooser.chooseMethod(methodString);
		sorter.accept(arr);
		
		Helper.printOutput(arr);
	}
}