package generatingCombinations;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] possibleNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		int[] vector = new int[n];
		genCombs(possibleNumbers, vector, 0, 0);
	}

	public static void genCombs(int[] possibleNumbers, int[] vector, int index, int border) {
		if (index > vector.length - 1) {
			System.out.println(Arrays.stream(vector).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}
		
		for (int i = border; i < possibleNumbers.length; i++) {
			vector[index] = possibleNumbers[i];
			genCombs(possibleNumbers, vector, index + 1, i + 1);
		}
	}
}