package connectedAreasinMatrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
	static char[][] matrix;
	static int size = 0;
	static LinkedHashMap<Integer[], Integer> storeHashMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int rows = 0;
		int cols = 0;

		try {
			System.out.print("Enter matrix rows num: ");
			rows = Integer.parseInt(bReader.readLine());
			System.out.print("Enter matrix cols num: ");
			cols = Integer.parseInt(bReader.readLine());
			matrix = new char[rows][cols];

			System.out.print("Enter matrix itself: ");
			for (int i = 0; i < rows; i++) {
				char[] chars = bReader.readLine().toCharArray();
				for (int j = 0; j < chars.length; j++) {
					matrix[i][j] = chars[j];
				}
			}
		} catch (Exception e) {
			System.out.println("something went wrong ;`(");
			return;
		}

		Integer[] coordinats = findFreeSpot(0, 0);

		while (coordinats != null) {
			findPath(coordinats[0], coordinats[1]);
			storeHashMap.put(coordinats, size);
			size = 0;
			coordinats = findFreeSpot(coordinats[0], coordinats[1]);
		}

		printResult();
	}

	private static void printResult() {
		System.out.println(String.format("Total areas found: %d",
				storeHashMap.size()));

		List<Map.Entry<Integer[], Integer>> list = new ArrayList<Map.Entry<Integer[], Integer>>(storeHashMap.entrySet());
		list.sort(Map.Entry.comparingByValue((a, b) -> b - a));

		Map<Integer[], Integer> result = new LinkedHashMap<>();
		for (Map.Entry<Integer[], Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		int counter = 1;
		for (Integer[] integers : result.keySet()){
			System.out.println(String.format("Area #%d at (%d, %d), size: %d",
					counter++,
					integers[0],
					integers[1],
					storeHashMap.get(integers)
			));
		}
	}

	private static Integer[] findFreeSpot(int row, int col) {
		for (int i = row; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '-'){
					return new Integer[] {i, j};
				}
			}
		}

		return null;
	}

	private static void findPath(int row, int col) {

		if (isOutsideMatrix(row, col)) {
			return;
		}

		if (isWall(row, col)) {
			return;
		}

		if (isVisited(row, col)) {
			return;
		}

		markVisited(row, col);
		size++;
		findPath(row, col + 1);
		findPath(row, col - 1);
		findPath(row + 1, col);
		findPath(row - 1, col);
	}

	private static void markVisited(int row, int col) {
		matrix[row][col] = 'V';

	}

	private static boolean isVisited(int row, int col) {
		return matrix[row][col] == 'V';
	}

	private static boolean isWall(int row, int col) {
		return matrix[row][col] == '*';
	}

	private static boolean isOutsideMatrix(int row, int col) {
		return !(row >= 0 &&
				row < matrix.length &&
				col >= 0 &&
				col < matrix[0].length);
	}
}