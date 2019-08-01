package needles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static String nums;
	static int[] arr;
	static int[] needles;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int c = Integer.parseInt(tokens[0]);
        tokens = reader.readLine().split(" ");
        arr = parseInput(tokens);
        tokens = reader.readLine().split(" ");
        needles = parseInput(tokens);

		for (int needle : needles) {
			int index = 0;
			index = findPlace(needle, index);
			System.out.print(index + " ");
		}
	}

	 private static int[] parseInput(String[] tokens) {
        int[] array = new int[tokens.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }

        return array;
    }
	 
//	private static int[] readSomething() throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int[] f = Arrays.stream(br.readLine().trim().split("\\s+"))
//				.filter(df -> df.isEmpty() != true)
//				.mapToInt(Integer::parseInt)
//				.toArray();
//		return f;
//	}

	private static int findPlace(int needle, int start) {
		if (start == 0 && arr[start] != 0 && arr[start] >= needle) {
			return 0;
		}
		
		int end = -1;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] >= needle && arr[i - 1] == 0) {
				end = i;
				break;
			} else if (needle > arr[i] ) {
				continue;
			} else {
				return i;
			}
		}
		
		if (end == -1 && arr[arr.length - 1] != 0) {
			return arr.length;
		} else if (end == -1) {
			end = arr.length - 1;
		}
		
		for (int i = end; i >= start; i--) {
			if (arr[i] == needle || arr[i] > needle) {
				continue;
			} else if (arr[i] == 0) {
				continue;
			} else {
				
				return i + 1;
			}
		}
		
		return 0;
	}
}