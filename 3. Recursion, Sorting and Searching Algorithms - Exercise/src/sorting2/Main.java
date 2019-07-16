package sorting2;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	// counting sort
	public static Map<Integer, Integer> tempArr = new TreeMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		scanner.close();
		
		count(arr);
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Integer>kvp : tempArr.entrySet()) {
			for (int i = 0; i < kvp.getValue(); i++) {
				sb.append(kvp.getKey() + " ");
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void count(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int currentElement = arr[i];
			tempArr.putIfAbsent(currentElement, 0);
			tempArr.put(currentElement, tempArr.get(currentElement) + 1);
		}
	}
}