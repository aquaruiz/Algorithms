package generatingCombinations;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] set = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		int[] vector = new int[n];
		genCombs(set, vector, 0, 0);
	}

	public static void genCombs(int[] set, int[] vector, int index, int border) {
		if (index >= vector.length) {
			System.out.println(Arrays.stream(vector).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}
		
		for (int i = border; i < set.length; i++) {
			vector[index] = set[i];
			genCombs(set, vector, index + 1, i + 1);
		}
	}
}
