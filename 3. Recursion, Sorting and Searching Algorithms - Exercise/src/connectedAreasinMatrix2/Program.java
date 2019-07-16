package connectedAreasinMatrix2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	private static final char WALL = '*';
	private static final char VISITED = 'v';
	
	private static char[][] matrix;
	private static List<Area> areas = new ArrayList<Area>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());
		
		matrix = new char[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}
		
		scanner.close();
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				checkTraversablity(row, col);
			}
		}
		
		System.out.printf("Total areas found: %d%n", areas.size());
		
		areas.sort((a, b) -> a.compareTo(b));
		
		if (areas.size() > 0) {
			for (Area area : areas) {
				System.out.printf("Area #%d at (%d, %d), size: %d%n", 
						areas.indexOf(area) + 1,
						area.row,
						area.col,
						area.size);
			}
		}
	}
	
	private static void checkTraversablity(int row, int col) {
		if (!isTraversable(row, col)) {
			return;
		}
		
		Area area = new Area(row, col);
		createArea(row, col, area);
		
		areas.add(area);
	}

	private static void createArea(int row, int col, Area area) {
		if (!isTraversable(row, col)) {
			return;
		}
		
		matrix[row][col] = 'v';
		area.size++;
		
		createArea(row + 1, col, area);
		createArea(row - 1, col, area);
		createArea(row, col + 1, area);
		createArea(row, col - 1, area);
	}

	private static boolean isTraversable(int row, int col) {
		
		if (row < 0) {
			return false;
		}
		
		if (col < 0) {
			return false;
		}

		if (row >= matrix.length) {
			return false;
		}

		if (col >= matrix[0].length) {
			return false;
		}
		
		if (matrix[row][col] == WALL) {
			return false;
		}
		
		if (matrix[row][col] == VISITED) {
			return false;
		}

		return true;
	}
}

class Area implements Comparable<Area>{
	public int row;
	public int col;
	public int size;
	
	public Area(int row, int col) {
		this.row = row;
		this.col = col;
		this.size = 0;
	}
	
	@Override
	public int compareTo(Area o) {
		int cmp = o.size - this.size;
		
		if (cmp == 0) {
			cmp = this.row - o.row;
		}
		
		if (cmp == 0) {
			cmp = this.col - o.col;
		}
		
		return cmp;
	}
}