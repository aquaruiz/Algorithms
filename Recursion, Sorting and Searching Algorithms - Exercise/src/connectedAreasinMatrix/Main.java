package connectedAreasinMatrix;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static char[][] matrix;
	public static Set<Area> areas = new TreeSet<>();
	
//	public static class Area implements Comparable<Area> {
//		private int row;
//		private int col;
//		private int size;
//		
//		public Area(int row, int col, int size) {
//			this.setRow(row);
//			this.setCol(col);
//			this.setSize(size);
//		}
//	
//		public int getCol() {
//			return col;
//		}
//		
//		private void setCol(int col) {
//			this.col = col;
//		}
//		
//		public int getRow() {
//			return row;
//		}
//		
//		private void setRow(int row) {
//			this.row = row;
//		}
//		
//		public int getSize() {
//			return size;
//		}
//		
//		public void setSize(int size) {
//			this.size = size;
//		}
//		
//		@Override
//		public int compareTo(Area other) {
//			if (this.size != other.size) {
//				return other.size - this.size;
//			}
//			
//			if (this.row != other.row) {
//				return this.row - other.row;
//			}
//			
//			return this.col - other.col;
//		}
//	}
//
//	public static class Cell {
//		private int row;
//		private int col;
//		
//		public Cell(int row, int col) {
//			this.setRow(row);
//			this.setCol(col);
//		}
//		
//		public int getRow() {
//			return row;
//		}
//		
//		public int getCol() {
//			return col;
//		}
//		
//		private void setCol(int col) {
//			this.col = col;
//		}
//		
//		private void setRow(int row) {
//			this.row = row;
//		}
//	}
//

	// input
	//  4
	//	9
	//	---*---*-
	//	---*---*-
	//	---*---*-
	//	----*-*--
	// output
	// Total areas found: 3
	//	Area #1 at (0, 0), size: 13
	//	Area #2 at (0, 4), size: 10
	//	Area #3 at (0, 8), size: 5
	
	// input
	//  5
	//	10
	//	*--*---*--
	//	*--*---*--
	//	*--*****--
	//	*--*---*--
	//	*--*---*--
	// output
	// Total areas found: 4
	//	Area #1 at (0, 1), size: 10
	//	Area #2 at (0, 8), size: 10
	//	Area #3 at (0, 4), size: 6
	//	Area #4 at (3, 4), size: 6
	
	public static void main(String[] args) {
		readMatrix();
		Cell unmarkedCell = findCell();
		
		while (unmarkedCell != null) {
			Area currentArea = new Area(unmarkedCell.getRow(), unmarkedCell.getCol(), 0);
			int size = traverseArea(currentArea.getRow(), currentArea.getCol());
			currentArea.setSize(size);
			
			areas.add(currentArea);
			
			unmarkedCell = findCell();
		}

		System.out.println("Total areas found: " + areas.size());
		int counter = 1;
		
		for (Area area : areas) {
			System.out.println(String.format("Area #%d at (%d, %d), size: %d", 
					counter++,
					area.getRow(),
					area.getCol(),
					area.getSize()));
		}
	}

	private static int traverseArea(int row, int col) {
		if (row < 0
				|| col < 0
				|| row >= matrix.length
				|| col >= matrix[0].length
				|| matrix[row][col] == '*'
				|| matrix[row][col] == 'v') {
			return 0;
		} else {
			matrix[row][col] = 'v';
			
			return 1 
				+ traverseArea(row - 1, col)
				+ traverseArea(row + 1, col)
				+ traverseArea(row, col - 1)
				+ traverseArea(row, col + 1);
		}
	}

	private static Cell findCell() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != '*' && matrix[i][j] != 'v') {
					return new Cell(i , j);
				}
			}
		}

		return null;
	}

	private static void readMatrix() {
		Scanner scanner = new Scanner(System.in);
		int rows = Integer.parseInt(scanner.nextLine());
		@SuppressWarnings("unused")
		int cols = Integer.parseInt(scanner.nextLine());
		
		
		matrix = new char[rows][];
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}
		
		scanner.close();
	}
}