package needles2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		TreeMap<Integer, Integer> numberIndexes = new TreeMap<>();
		String[] counts = in.readLine().split(" ");
		int numbersCount = Integer.parseInt(counts[0]);
		int needlesCount = Integer.parseInt(counts[1]);
	
		String[] numbers = in.readLine().split(" ");
		String[] needles = in.readLine().split(" ");
		
		fillSpecialMap(numberIndexes, numbersCount, 0, 0, numbers);

		for (int i = 0; i < needlesCount; i++) {
			int currentNeedle = Integer.parseInt(needles[i]);
			
			try {
				int searchedNumberKey = numberIndexes.containsKey(currentNeedle) ?
						currentNeedle : numberIndexes.ceilingKey(currentNeedle);
				int foundNumber = numberIndexes.get(searchedNumberKey);
				sb.append(foundNumber).append(" ");
			} catch (NullPointerException e) {
				boolean hasFound = false;
				
				for (int j = numbers.length - 1; j >= 0; j--) {
					if (!numbers[j].equals("0")) {
						sb.append(j  + 1).append(" ");
						hasFound = true;
						break;
					}
				}
				
				if (!hasFound) {
					sb.append(0).append(" ");
				}
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void fillSpecialMap(TreeMap<Integer, Integer> numberIndexes, int numbersCount, int i, int j,
			String[] numbers) {
		int zeros = 0;
		int index = 0;
		
		for (int k = 0; k < numbersCount; k++) {
			int currentNumber = Integer.parseInt(numbers[k]);
			
			if (currentNumber != 0 && !numberIndexes.containsKey(currentNumber)) {
				numberIndexes.put(currentNumber, index - zeros);
			}
			
			if (currentNumber == 0) {
				zeros++;
			} else {
				zeros = 0;
			}
			
			index++;
		}
	}
}