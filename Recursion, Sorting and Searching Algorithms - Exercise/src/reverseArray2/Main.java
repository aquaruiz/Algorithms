package reverseArray2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		scanner.close();
		reverseArray(array, 0, array.length - 1);

		System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	private static void reverseArray(int[] array, int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex) {
			// swap
			int temp = array[firstIndex];
			array[firstIndex] = array[lastIndex];
			array[lastIndex] = temp;
			
			reverseArray(array, firstIndex + 1, lastIndex - 1);
		}
	}
}