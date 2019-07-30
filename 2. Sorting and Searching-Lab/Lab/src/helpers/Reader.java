package helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Reader {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Integer[] readArray() {
		
		try {
			Integer[] arr = Arrays.stream(br.readLine().split("\\s+"))
					.map(Integer::parseInt)
					.toArray(Integer[]::new);
			return arr;
		} catch (Exception e) {
			System.out.println("Something went wrong ;`(");
			return null;
		}
	}

	public static Integer readInt() {
		
		try {
			Integer inty = Integer.parseInt(br.readLine().trim());
			return inty;
		} catch (Exception e) {
			System.out.println("Something went wrong ;`(");
			return null;
		}
	}

	public static String readMethod() {
		try {
			String string = br.readLine().trim().toLowerCase();
			return string;
		} catch (Exception e) {
			System.out.println("Something went wrong ;`(");
			return null;
		}
	}
}