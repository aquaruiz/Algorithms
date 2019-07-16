package shuffleFisherYates;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Shuffle.FisherYates(arr);

		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
	}

}
