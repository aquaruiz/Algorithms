package combinationsWithoutRepetition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static int k;
	public static int n;
	public static String[] arr;
	public static String[] combinations;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		arr = scanner.nextLine().split(" ");
		n = arr.length;
		k = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		combinations = new String[k];
		comb(0, 0);
		
	}

	public static void comb(int index, int start) {
		if (index >= k) {
			System.out.println(Arrays.stream(combinations).collect(Collectors.joining(" ")));
		} else {
			for (int i = start; i < n; i++) {
				combinations[index] = arr[i];
				comb(index + 1, i + 1);
			}
		}
	}
}