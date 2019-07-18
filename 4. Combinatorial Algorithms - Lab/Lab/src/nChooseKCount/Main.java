package nChooseKCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int k = 0;
		
		try {
			System.out.print("Enter n: ");
			n = Integer.parseInt(bReader.readLine());
			System.out.print("Enter k: ");
			k = Integer.parseInt(bReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Something went wrong :`(");
		}
		
		long coef = calcBinCoef(n, k); 
		System.out.println(coef);
	}

	private static long calcBinCoef(int n, int k) {
		if (k > n) {
			return 0l;
		}
		
		if (k == 0 || k == n) {
			return 1l;
		}
		
		return calcBinCoef(n - 1, k - 1) + calcBinCoef(n - 1, k);
	}
}