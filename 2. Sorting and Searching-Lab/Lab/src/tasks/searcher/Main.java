package tasks.searcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr;
	public static int needle;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = bReader.readLine().split(" ");
		arr = new int[inputs.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		needle = Integer.parseInt(bReader.readLine());
		
		int index = linearSearch();
		System.out.println(index);
	}

	private static int linearSearch() {
		int index = - 1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == needle) {
				index = i;
				break;
			}
		}
		
		return index;		
	}
}