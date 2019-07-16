package variationsWithoutRepetition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static int k;
	public static String[] elements;
	public static String[] variations;
	public static boolean[] used;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		elements = scanner.nextLine().split(" ");
		k = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		variations = new String[k];
		used = new boolean[elements.length];
		
		gen(0);
	}

	
	private static void gen(int index) {
		if (index >= k) {
			System.out.println(Arrays.stream(variations).collect(Collectors.joining(" ")));
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!used[i]) {
					used[i] = true;
					variations[index] = elements[i];
					gen(index + 1);
					used[i] = false;
				}
			}
		}
	}
}
