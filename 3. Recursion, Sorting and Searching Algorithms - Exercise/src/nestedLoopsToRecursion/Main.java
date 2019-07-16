package nestedLoopsToRecursion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	private static int[] loops;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int loopsNum = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		loops = new int[loopsNum];
		
		nestedLoops(loopsNum, 0);
	}

	private static void nestedLoops(int loopsNum, int currentLoop) {
		if (currentLoop == loopsNum) {
			print();
			return;
		}
		
		for (int i = 1; i <= loopsNum; i++) {
			loops[currentLoop] = i;
			nestedLoops(loopsNum, currentLoop + 1);
		}
	}

	private static void print() {
		System.out.println(Arrays.stream(loops).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}