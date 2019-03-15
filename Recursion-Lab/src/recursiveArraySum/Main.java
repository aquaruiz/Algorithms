package recursiveArraySum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
		scanner.close();;
		
		int sum = sum(arr, 0);
		System.out.println(sum);
	}
	
	public static int sum(int[] arr, int index) {
		if (index == arr.length) {
			return 0;
		}
		
		return arr[index] + sum(arr, index + 1);
	}

}
