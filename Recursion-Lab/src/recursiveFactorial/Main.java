package recursiveFactorial;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nFactorial = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		long factorial = factorial(nFactorial);
		System.out.println(factorial);
	}
	
	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}
}