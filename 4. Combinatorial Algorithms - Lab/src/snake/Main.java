package snake;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static String[] currentSnake;
	public static Set<String> visitedCells = new HashSet<>();
	public static Set<String> result = new HashSet<>();
	public static Set<String> allPossibleSnakes = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		scanner.close();
		
		currentSnake = new String[n];
		
		generateSnakes(0, 0, 0, "S");
		
		for (String snake : result) {
			System.out.println(snake);
		}
		
		System.out.println("Snakes count = " + result.size());
	}
	
	public static void generateSnakes(int index, int row, int col, String direction) {
		if (index == currentSnake.length) {
			markSnake();
		} else {
			currentSnake[index] = direction;
			
			String cellString = String.format("%s %s", row, col);
			
			if (!visitedCells.contains(cellString)) {
				visitedCells.add(cellString);
				
				generateSnakes(index + 1, row, col + 1, "R");
				generateSnakes(index + 1, row + 1, col, "D");
				generateSnakes(index + 1, row, col - 1, "L");
				generateSnakes(index + 1, row - 1, col, "U");

				visitedCells.remove(cellString)
;			}
		}
	}

	private static void markSnake() {
		String normalSnake = String.join("", currentSnake);
		
		if (allPossibleSnakes.contains(normalSnake)) {
			return;
		}
		
		result.add(normalSnake);
		String flippedSnake = flip(normalSnake);
		String reversedSnake = reverse(normalSnake);
		String reversedFlippedSnake = flip(reversedSnake);
		
		for (int i = 0; i < 4; i++) {
			allPossibleSnakes.add(normalSnake);
			normalSnake = rotate(normalSnake);
			
			allPossibleSnakes.add(flippedSnake);
			flippedSnake = rotate(flippedSnake);
			
			allPossibleSnakes.add(reversedSnake);
			reversedSnake = rotate(reversedSnake);
			
			allPossibleSnakes.add(reversedFlippedSnake);
			reversedFlippedSnake = rotate(reversedFlippedSnake);
		}
	}

	private static String rotate(String snake) {
		String[] newSnake = new String[snake.length()];
		
		for (int i = 0; i < snake.length(); i++) {
			switch (snake.charAt(i)) {
			case 'R':
				newSnake[i] = "D";
				break;
			case 'D':
				newSnake[i] = "L";
				break;
			case 'L':
				newSnake[i] = "U";
				break;
			case 'U':
				newSnake[i] = "R";
				break;
			default:
				newSnake[i] = Character.toString(snake.charAt(i));
				break;
			}
		}
		return String.join("", newSnake);
	}
	
	private static String reverse(String snake) {
		String[] newSnake = new String[snake.length()];
		
		newSnake[0] = "S";
		
		for (int i = 1; i < snake.length(); i++) {
			newSnake[snake.length() - i] = Character.toString(snake.charAt(i));

		}
		
		return String.join("", newSnake);
	}

	private static String flip(String snake) {
		String[] newSnake = new String[snake.length()];
		
		for (int i = 0; i < snake.length(); i++) {
			switch (snake.charAt(i)) {
			case 'U':
				newSnake[i] = "D";
				break;
			case 'D':
				newSnake[i] = "U";				
				break;
			default:
				newSnake[i] = Character.toString(snake.charAt(i));
				break;
			}
		}
		
		return String.join("", newSnake);
	}
}
