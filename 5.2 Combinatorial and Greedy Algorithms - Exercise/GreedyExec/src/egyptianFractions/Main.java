package egyptianFractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(bReader.readLine().split("\\/")).mapToInt(Integer::parseInt).toArray();
		int numerator = input[0];
		int denominator = input[1];

		if (numerator >= denominator || denominator == 0) {
			System.out.println("Error (fraction is equal to or greater than 1)");
			return;
		}
		
		System.out.print(String.format("%d/%d = ", numerator, denominator));
		
		printEgyptianFractions(numerator, denominator);
	}

	private static void printEgyptianFractions(int numerator, int denominator) {
		if (denominator == 0 || numerator == 0) {
			return;
		}
		
		if (denominator % numerator == 0) {
			System.out.print("1/" + denominator / numerator); 
            return; 
		}
		
		if (numerator % denominator == 0) {
			System.out.println(numerator / denominator);
			return;
		}
		
		if (numerator > denominator) {
			System.out.println(numerator / denominator + " + ");
			printEgyptianFractions(numerator % denominator, denominator);
			return;
		}
		
		int n = denominator / numerator + 1;
		System.out.print("1/" + n + " + ");
//		int newNumerator = Math.abs(denominator / n - numerator);
//		int newDenominator = denominator;
		int newNumerator = numerator * n - denominator;
		int newDenominator = denominator * n;
		printEgyptianFractions(newNumerator, newDenominator);
	}
}