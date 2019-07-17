package the8QueensPuzzle;

import java.util.HashSet;
import java.util.Set;

public class Main {
	static final int SIZE = 8;
	static boolean[][] chessBoard = new boolean[SIZE][SIZE];
	static int foundSolutions = 0;

	static Set<Integer> attackedRows = new HashSet<>(); // 8 from 0 to 7
	static Set<Integer> attackedCols = new HashSet<>(); // 8 from 0 to 7
	static Set<Integer> attackedLeftDiagonals = new HashSet<>(); // 15 from -7 to 7
	static Set<Integer> attackedRightDiagonals = new HashSet<>(); // 15 from -7 to 7
	
	public static void main(String[] args) {
		putQueen(0);
//		System.out.println(foundSolutions);
	}
	
	private static void printChessBoard() {
		for (boolean[] row : chessBoard) {
			for (boolean col : row) {
				System.out.print(col ? "* " : "- ");
			}

			System.out.println();
		}
	}

	private static void putQueen(int row) {
		if (row == SIZE) {
			foundSolutions++;
			printChessBoard();
			System.out.println();
		} else {
			for (int col = 0; col < SIZE; col++) {
				if (canPlaceQueen(row, col)) {
					markAllAttackedPositions(row, col);
					putQueen(row + 1); 
					unmarkAllAttackedPositions(row, col);
				}
			}
		}
	}

	private static boolean canPlaceQueen(int row, int col) {
		return
			!attackedRows.contains(row) &&
			!attackedCols.contains(col) &&
			!attackedRightDiagonals.contains(col + row) &&
			!attackedLeftDiagonals.contains(col - row);
	}
	
	private static void markAllAttackedPositions(int row, int col) {
		attackedRows.add(row);
		attackedCols.add(col);
		attackedRightDiagonals.add(row + col);
		attackedLeftDiagonals.add(col - row);
		chessBoard[row][col] = true;
	}

	private static void unmarkAllAttackedPositions(int row, int col) {
		attackedRows.remove(row);
		attackedCols.remove(col);
		attackedRightDiagonals.remove(col + row);
		attackedLeftDiagonals.remove(col - row);
		chessBoard[row][col] = false;
	}
}