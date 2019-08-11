package snakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
	static int maxLenght;
	static int snakeCount;
	static Set<String> usedSnakes = new LinkedHashSet<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		maxLenght = Integer.parseInt(bReader.readLine());
		bReader.close();
		
		ArrayDeque<Cell> snake = new ArrayDeque<>();
		List<Character> directions = new ArrayList<>() ;
		
		// R -> D -> L -> U
		Cell currentNewCell = new Cell(0, 0);
		generateSnake(currentNewCell, 'S', snake, directions);
		System.out.println("Snakes count = " + snakeCount);
	}
	
	private static void generateSnake(Cell cell, char direction, ArrayDeque<Cell> snake, List<Character> directions) {
		if (snake.size() == maxLenght) {
			String currentSnake = String.valueOf(directions);
					
			if (!usedSnakes.contains(currentSnake)) {
				System.out.println(currentSnake.replaceAll("[ ,\\[\\]]", ""));
				snakeCount++;
				usedSnakes.add(currentSnake);
				markIsomorphicSnakes(directions);
			}
			
			return;
		}
		
		if (snake.contains(cell)) {
			return;
		}
		
		snake.addLast(cell);
		directions.add(direction);
		
		Cell newCell = new Cell(cell.getRow(), cell.getCol() + 1);
		generateSnake(newCell, 'R', snake, directions);
		
		if (snake.size() > 1) {
			newCell = new Cell(cell.getRow() + 1, cell.getCol());
			generateSnake(newCell, 'D', snake, directions);
		}
		
		if (snake.size() > 2) {
			newCell = new Cell(cell.getRow(), cell.getCol() - 1);
			generateSnake(newCell, 'L', snake, directions);
		}
		
		if (snake.size() > 3) {
			newCell = new Cell(cell.getRow() - 1, cell.getCol());
			generateSnake(newCell, 'U', snake, directions);
		}
		
		snake.removeLast();
		directions.remove(directions.size() - 1);
	}

	private static void markIsomorphicSnakes(List<Character> directions) {
		flipSnake(directions);
		usedSnakes.add(String.valueOf(directions));
		
		switchSnakeHeadAndTail(directions);
		usedSnakes.add(String.valueOf(directions));
		Collections.reverse(directions);
		usedSnakes.add(String.valueOf(directions));
		
		while (directions.get(1) != 'R') {
			rotateSnakeClockwise(directions);
		}
		
		usedSnakes.add(String.valueOf(directions));
		flipSnake(directions);
		usedSnakes.add(String.valueOf(directions));
	}

	private static void rotateSnakeClockwise(List<Character> directions) {
		for (int i = 0; i < directions.size(); i++) {
			switch (directions.get(i)) {
			case 'U':
				directions.set(i, 'R');
				break;
			case 'D':
				directions.set(i, 'L');
				break;
			case 'R':
				directions.set(i, 'D');
				break;
			case 'L':
				directions.set(i, 'U');
				break;
			}
		}
	}

	private static void switchSnakeHeadAndTail(List<Character> directions) {
		char temp = directions.remove(0);
		directions.add(temp);
		
		for (int i = 0; i < directions.size(); i++) {
			switch (directions.get(i)) {
			case 'U':
				directions.set(i, 'D');
				break;
			case 'D':
				directions.set(i, 'U');
				break;
			case 'R':
				directions.set(i, 'L');
				break;
			case 'L':
				directions.set(i, 'R');
				break;
			}
		}
	}

	private static void flipSnake(List<Character> directions) {
		for (int i = 0; i < directions.size(); i++) {
			switch (directions.get(i)) {
			case 'U':
				directions.set(i, 'D');
				break;
			case 'D':
				directions.set(i, 'U');
				break;
			}
		}
	}

	public static class Cell {
		private int row;
		private int col;
		
		public Cell() {
		}
		
		public Cell(int row, int col) {
			setRow(row);
			setCol(col);
		}
		
		public int getRow() {
			return row;
		}
		
		public int getCol() {
			return col;
		}
		
		public void setRow(int row) {
			this.row = row;
		}
		
		public void setCol(int col) {
			this.col = col;
		}
	}
}