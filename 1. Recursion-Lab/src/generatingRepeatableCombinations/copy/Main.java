package generatingRepeatableCombinations.copy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		int[] vector = new int[n];
		genCombs(vector, 0, 3);
	}

	public static void genCombs(int[] vector, int index, int n) {
		if (index >= vector.length) {
			System.out.println(Arrays.stream(vector).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			vector[index] = i;
			genCombs(vector, index + 1, n);
		}
	}
}