package nChooseKCount;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        
        scanner.close();
        
        BigInteger count = calculateFactorial(n)
        		.divide(calculateFactorial(n - k).multiply(calculateFactorial(k)));

        System.out.println(count);
    }

    public static BigInteger calculateFactorial(int number) {
        BigInteger fact = BigInteger.valueOf(1);

        for(int i = 2; i<= number; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        return fact;
    }
}