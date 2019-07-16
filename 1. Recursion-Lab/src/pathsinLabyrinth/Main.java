package pathsinLabyrinth;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	
	static char[][] labyrint;
	static List<Character> path = new LinkedList<>();
	
	public static void main(String[] args) {
		labyrint = readLabyrint();
		findPaths(0, 0, 'S');
	}

	public static void findPaths(int row, int col, char direction) {
		if (!isInBound(row, col)) {
			return;
		}
		
		path.add(direction);
		
		if (isExit(row, col)) {
			printPath();
		} else if (!isVisited(row, col) && isFree(row, col)) {
			mark(row, col);
			findPaths(row, col + 1, 'R');
			findPaths(row + 1, col, 'D');
			findPaths(row, col - 1, 'L');
			findPaths(row - 1, col, 'U');
			unmark(row, col);
		}
		
		path.remove(path.size() - 1);
	}

	private static void unmark(int row, int col) {
		labyrint[row][col] = '-';
	}

	private static void mark(int row, int col) {
		labyrint[row][col] = 'v';
	}

	private static boolean isFree(int row, int col) {
		return labyrint[row][col] == '-';
	}

	private static boolean isVisited(int row, int col) {
		return false;
	}

	private static void printPath() {
		System.out.println(path.stream()
						.filter(e -> e != 'S')
						.map(e->e.toString())
						.collect(Collectors.joining()));
	}

	private static boolean isExit(int row, int col) {
		return labyrint[row][col] == 'e';
	}

	private static boolean isInBound(int row, int col) {
		boolean isRowExist = row >= 0
						&& row < labyrint.length;
		boolean isColExist = col >= 0
						&& col < labyrint[0].length;
		
		return isRowExist && isColExist;
	}

	private static char[][] readLabyrint() {
		Scanner scanner = new Scanner(System.in);
		int row = Integer.parseInt(scanner.nextLine());
		int col = Integer.parseInt(scanner.nextLine());
		
		char[][] labyrint = new char[row][col];
		for (int i = 0; i < row; i++) {
			labyrint[i] = scanner.nextLine().toCharArray();
		}
	
		scanner.close();
		return labyrint;
	}
}