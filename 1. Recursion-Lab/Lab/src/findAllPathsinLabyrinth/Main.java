package findAllPathsinLabyrinth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static char[][] labyrinth = new char[][] {
												{'-', '*', '*', '-', 'e'},
												{'-', '-', '-', '-', '-'},
												{'*', '*', '*', '*', '*'}
											};
											
	static List<Character> path = new ArrayList<Character>();
							
	public static void main(String[] args) {
		readLabyrinth();
		findPath(0, 0, 'S');
	}

	private static void findPath(int row, int col, char direction) {
		if (!isInsideLabyrinth(row, col)) {
			return;
		}
		
		if (isWall(row, col) || isVisited(row, col)) {
			return;
		}
		
		path.add(direction);
		
		if (isExit(row, col)) {
//			System.out.println("Found exit");
			System.out.println(
						path.stream()
						.skip(1)
						.map(String::valueOf)
						.collect(Collectors.joining(""))
					);
		} else {
			markVisited(row, col);
			
			findPath(row, col + 1, 'R');
			findPath(row + 1, col, 'D');
			findPath(row, col - 1, 'L');
			findPath(row - 1, col, 'U');

			unmarkVisited(row, col);
		}
		
		path.remove(path.size() - 1);
	}

	private static void unmarkVisited(int row, int col) {
		labyrinth[row][col] = '-';
	}

	private static void markVisited(int row, int col) {
		labyrinth[row][col] = 'V';
	}

	private static boolean isVisited(int row, int col) {
		return labyrinth[row][col] == 'V';
	}

	private static boolean isWall(int row, int col) {
		return labyrinth[row][col] == '*';
	}

	private static boolean isExit(int row, int col) {
		return labyrinth[row][col] == 'e';
	}

	private static boolean isInsideLabyrinth(int row, int col) {
		return row >= 0 &&
				row < labyrinth.length &&
				col >= 0 &&
				col < labyrinth[0].length;
	}

	private static void readLabyrinth() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int row = Integer.parseInt(bReader.readLine());
			int col = Integer.parseInt(bReader.readLine());
			labyrinth = new char[row][col];
			
			for (int i = 0; i < row; i++) {
				char[] chars = bReader.readLine().toCharArray();
				for (int j = 0; j < col; j++) {
					labyrinth[i][j] = chars[j];
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Something went wrong ;`(");
		}
		
	}
}