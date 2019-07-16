package quicksort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String line = scanner.nextLine();
		
		scanner.close();
		
		if (line.isEmpty()) {
			return;
		}
		
		Integer[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		
		Quick.sort(arr);
		System.out.println(Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining(" ")));
	}
}