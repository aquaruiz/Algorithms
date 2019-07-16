package generating01Vectors;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		int[] vector = new int[n];
		gen01(vector, 0);
	}

	private static void gen01(int[] vector, int index) {
		if (index > vector.length - 1) {
			System.out.println(Arrays.stream(vector)
									.mapToObj(String::valueOf)
									.collect(Collectors.joining(" ")));
		} else {
			vector[index] = 0;
			gen01(vector, index + 1);
			vector[index] = 1;
			gen01(vector, index + 1);
			
		}
	}
}