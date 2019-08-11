package knightsTour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static List<Cell> board = new ArrayList<>();
	static int boardSize;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(bReader.readLine());
		boardSize = size;
		
		for (byte i = 1; i <= size; i++) {
			for (byte j = 1; j <= size; j++) {
				board.add(new Cell(i, j));
			}
		}
		
		int counter = 1;
		
		Cell currentCell = board.get(0);
		currentCell.isVisited = true;
		currentCell.countVisits = counter++;
		
		while (board.stream().filter(c -> !c.isVisited).count() > 0) {
			currentCell = selectNextCell(currentCell);
			currentCell.isVisited = true;
			currentCell.countVisits = counter++;
		}

		printBoard(size);
	}

	private static void printBoard(int count) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				System.out.print( String.format("% 4d", board.get(i * count + j).countVisits));
			}
			
			System.out.println();
		}
	}

	private static Cell selectNextCell(Cell currentCell) {
		// left up
		Cell upperTopLeft = board.stream().filter(c -> c.row == currentCell.row - 2 && c.col == currentCell.col - 1).findFirst().orElse(null);
		Cell lowerTopLeft = board.stream().filter(c -> c.row == currentCell.row - 1 && c.col == currentCell.col - 2).findFirst().orElse(null);
		// right up
		Cell upperTopRight = board.stream().filter(c -> c.row == currentCell.row - 2 && c.col == currentCell.col + 1).findFirst().orElse(null);
		Cell lowerTopRight = board.stream().filter(c -> c.row == currentCell.row - 1 && c.col == currentCell.col + 2).findFirst().orElse(null);
		// left down
		Cell upperDownLeft = board.stream().filter(c -> c.row == currentCell.row + 1 && c.col == currentCell.col - 2).findFirst().orElse(null);
		Cell lowerDownLeft = board.stream().filter(c -> c.row == currentCell.row + 2 && c.col == currentCell.col - 1).findFirst().orElse(null);
		// right down
		Cell upperDownRight = board.stream().filter(c -> c.row == currentCell.row + 1 && c.col == currentCell.col + 2).findFirst().orElse(null);
		Cell lowerDownRight = board.stream().filter(c -> c.row == currentCell.row + 2 && c.col == currentCell.col + 1).findFirst().orElse(null);
	
		List<Cell> possibleMoves = Arrays.asList(
				// ordered by Ira Pohl Method - sort of...
				upperDownRight,
				lowerTopRight, 
				upperDownLeft, 
				lowerTopLeft,
				upperTopRight,
				lowerDownRight,
				upperTopLeft,
				lowerDownLeft)
				.stream()
			.filter(c -> c != null && !c.isVisited)
			.collect(Collectors.toList());
		
		Collections.sort(possibleMoves, new CalcutarePossibleMoves());
		return possibleMoves.get(0);
	}

	public static class CalcutarePossibleMoves implements Comparator<Cell>{

		@Override
		public int compare(Cell o1, Cell o2) {
			// left up
			Cell upperTopLeft = board.stream().filter(c -> c.row == o1.row - 2 && c.col == o1.col - 1).findFirst().orElse(null);
			Cell lowerTopLeft = board.stream().filter(c -> c.row == o1.row - 1 && c.col == o1.col - 2).findFirst().orElse(null);
			// right up
			Cell upperTopRight = board.stream().filter(c -> c.row == o1.row - 2 && c.col == o1.col + 1).findFirst().orElse(null);
			Cell lowerTopRight = board.stream().filter(c -> c.row == o1.row - 1 && c.col == o1.col + 2).findFirst().orElse(null);
			// left down
			Cell upperDownLeft = board.stream().filter(c -> c.row == o1.row + 1 && c.col == o1.col - 2).findFirst().orElse(null);
			Cell lowerDownLeft = board.stream().filter(c -> c.row == o1.row + 2 && c.col == o1.col - 1).findFirst().orElse(null);
			// right down
			Cell upperDownRight = board.stream().filter(c -> c.row == o1.row + 1 && c.col == o1.col + 2).findFirst().orElse(null);
			Cell lowerDownRight = board.stream().filter(c -> c.row == o1.row + 2 && c.col == o1.col + 1).findFirst().orElse(null);
			Long o1PossibleMoves = Arrays.asList(
					upperTopLeft, 
					lowerTopLeft, 
					upperTopRight, 
					lowerTopRight,
					upperDownLeft, 
					lowerDownLeft, 
					upperDownRight,
					lowerDownRight)
					.stream()
					.filter(c -> c != null && !c.isVisited)
					.count();
			
			// left up
			upperTopLeft = board.stream().filter(c -> c.row == o2.row - 2 && c.col == o2.col - 1).findFirst().orElse(null);
			lowerTopLeft = board.stream().filter(c -> c.row == o2.row - 1 && c.col == o2.col - 2).findFirst().orElse(null);
			// right up
			upperTopRight = board.stream().filter(c -> c.row == o2.row - 2 && c.col == o2.col + 1).findFirst().orElse(null);
			lowerTopRight = board.stream().filter(c -> c.row == o2.row - 1 && c.col == o2.col + 2).findFirst().orElse(null);
			// left down
			upperDownLeft = board.stream().filter(c -> c.row == o2.row + 1 && c.col == o2.col - 2).findFirst().orElse(null);
			lowerDownLeft = board.stream().filter(c -> c.row == o2.row + 2 && c.col == o2.col - 1).findFirst().orElse(null);
			// right down
			upperDownRight = board.stream().filter(c -> c.row == o2.row + 1 && c.col == o2.col + 2).findFirst().orElse(null);
			lowerDownRight = board.stream().filter(c -> c.row == o2.row + 2 && c.col == o2.col + 1).findFirst().orElse(null);
		
			Long o2PossibleMoves = Arrays.asList(
					upperTopLeft, 
					lowerTopLeft, 
					upperTopRight, 
					lowerTopRight,
					upperDownLeft, 
					lowerDownLeft, 
					upperDownRight,
					lowerDownRight)
				.stream()
				.filter(c -> c != null && !c.isVisited)
				.count();
			
			return o1PossibleMoves.compareTo(o2PossibleMoves);
		}
	}

	public static class Cell {
		public byte row;
		public byte col;
		public boolean isVisited;
		public int countVisits;
		
		public Cell() {
		}
		
		public Cell(byte row, byte col) {
			setCol(col);
			setRow(row);
		}
		
		public byte getCol() {
			return col;
		}
		
		public byte getRow() {
			return row;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public int getCountVisits() {
			return countVisits;
		}
		
		public void setIsVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}


		public void setRow(byte row) {
			this.row = row;
		}

		public void setCol(byte col) {
			this.col = col;
		}
		
		public void setCountVisits(int countVisits) {
			this.countVisits = countVisits;
		}
		
		@Override
		public String toString() {
			int sum = (row - 1) * boardSize + col;
			return sum + " -> " + countVisits + " ";
		}
	}
}