package permutationsWithoutRepetitions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
	public static String[] elements;
	
	// used extra memory
	public static String[] perm;
	public static boolean[] used;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		elements = scanner.nextLine().split(" ");
		scanner.close();
		int n = elements.length;
		perm = new String[n];
		used = new boolean[n];
		
		gen(0);
	}
	
	public static void gen(int index) {
		if (index >= elements.length) {
			System.out.println(Arrays.stream(perm)
					.collect(Collectors.joining(" ")));
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!used[i]) {
					used[i] = true;
					perm[index] = elements[i];
					gen(index + 1);
					used[i] = false;
				}
			}
		}
	}
}