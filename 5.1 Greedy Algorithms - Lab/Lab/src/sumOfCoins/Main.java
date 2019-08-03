package sumOfCoins;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        in.close();
        
        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        
        if (usedCoins.isEmpty()) {
        	throw new IllegalArgumentException();
		} else {
			System.out.println("Number of coins to take: " + 
						usedCoins
							.values()
							.stream()
							.mapToInt(Number::intValue)
							.sum());
			for (Map.Entry<Integer, Integer> kvp : usedCoins.entrySet()) {
				System.out.println(
							String.format("%d coin(s) with value %d", 
											kvp.getValue(),
											kvp.getKey())
						);
			}
		}
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
    	Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
    	Arrays.sort(coins);
//    	int[] sortedCoins = IntStream.range(0, coins.length)
//    			.map(i -> coins[coins.length - 1 - i])
//    			.toArray();
        while (targetSum > 0) {
        	for (int i = coins.length - 1; i >= 0; i--) {
        		int currentCoin = coins[i];
				if (Math.floor(targetSum / currentCoin) > 0) {
					int qnty = (int) Math.floor(targetSum / currentCoin);
					targetSum -= qnty * currentCoin;
					
					if (!usedCoins.containsKey(currentCoin)) {
						usedCoins.put(currentCoin, 0);
					}
					
					int currentCointCount = usedCoins.get(currentCoin);
					currentCointCount += qnty;
					usedCoins.put(currentCoin, currentCointCount);
					break;
				}
				
				if (i == coins.length - 1 && 
						(usedCoins.isEmpty() || targetSum < coins[0])) {
					throw new IllegalArgumentException();
//					return new LinkedHashMap<>();
				}
			}
        }

        return usedCoins;
    }
}