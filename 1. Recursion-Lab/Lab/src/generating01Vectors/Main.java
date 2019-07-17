package generating01Vectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("How big vector do you want to draw: ");

		int size = 0;
		try {
			size = Integer.parseInt(bReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Something went wrong ;`(");
		}
		
		int[] vector = new int[size];
		getAllVectors(vector, 0, size);
//		getAllVectors(vector, size - 1);
	}

	private static void getAllVectors(int[] vector, int index, int size) {
		if (index == size) {
			System.out.println(
					Arrays.stream(vector)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(""))
				);
			return;
		}
		
		for (int i = 0; i <=  1; i++) {
			vector[index] = i;
			getAllVectors(vector, index + 1, size);
		}
		
	}

//	private static void getAllVectors(int[] vector, int index) {
//		if (index < 0) {
//			System.out.println(
//					Arrays.stream(vector)
//					.mapToObj(String::valueOf)
//					.collect(Collectors.joining(" "))
//				);
//			return;
//		}
//		
//		for (int i = 0; i <=  1; i++) {
//			vector[index] = i;
//			getAllVectors(vector, index - 1);
//		}
//	}

}