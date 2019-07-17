package recursiveFactorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter num to give factorial: ");
		int num = 0;
		try {
			num = Integer.parseInt(bReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Something went wrong ;`(");
		}
		
		Long factorial = calcFactorial(num); 
		System.out.println(factorial);
	}

	private static Long calcFactorial(int num) {
		if (num == 1) {
			return 1L;
		}
		
		return num * calcFactorial(num - 1);
	}

}