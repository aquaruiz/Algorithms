package GreedyAlgorithmLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

        Map<Integer, Integer> usedCoins = Main.chooseCoins(coins, targetSum);
        

        for (Map.Entry<Integer, Integer> kvp : usedCoins.entrySet()) {
			System.out.println(String.format("%d coin(s) with value %d", 
					kvp.getValue(),
					kvp.getKey()));
		}
    }

    public static Map<Integer, Integer> Main.chooseCoins(int[] coins, int targetSum) {
    	Arrays.sort(coins);
    	Map<Integer, Integer> selectedCoins = new LinkedHashMap<>();
    	int currentIndex = coins.length - 1;
    	int totalSum = 0;
    	
        while (targetSum > 0 && currentIndex >= 0) {
        	if (totalSum + coins[currentIndex] > targetSum) {
				currentIndex--;
				continue;
			}
        	
        	if (!selectedCoins.containsKey(coins[currentIndex])) {
        		selectedCoins.put(coins[currentIndex], 0);
			}

        	int oldquantity = selectedCoins.get(coins[currentIndex]);
        	oldquantity++;
        	selectedCoins.put(coins[currentIndex], oldquantity);

        	targetSum -= coins[currentIndex];
        }
        
        if (targetSum > 0) {
			throw new IllegalArgumentException();
		}

        return selectedCoins;
    }
}
