package rodCutting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] price;
	static int[] bestPrice;
	static int[] bestCombo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
	    price = Arrays.stream( bReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    bestPrice = new int[price.length];
	    bestCombo = new int[price.length];
	    
	    int len = Integer.parseInt(bReader.readLine());
	    
	    int best = cutRod(len);
	    System.out.println(best);
	    reconstructSolution(len);
	}

	private static int cutRod(int n) {
		if (bestPrice[n] > 0) {
			return bestPrice[n];
		}
		
		if (n == 0) {
			return 0;
		}
		
		int currentBest = bestPrice[n];
		
		for (int i = 1; i <= n; i++) {
			currentBest = Math.max(currentBest, price[i] + cutRod(n - i));
			
			if (currentBest > bestPrice[n]) {
				bestPrice[n] = currentBest;
				bestCombo[n] = i;
			}
		}

		return bestPrice[n];
	}
	
	private static void reconstructSolution(int n) {
		while (n - bestCombo[n] != 0) {
			System.out.print(bestCombo[n] + " ");
			n = n - bestCombo[n];
		}
		
		System.out.println(bestCombo[n]);
	}
}
