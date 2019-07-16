package connectedAreasinMatrix;

public class Cell {
	private int row;
	private int col;
	
	public Cell(int row, int col) {
		this.setRow(row);
		this.setCol(col);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	private void setCol(int col) {
		this.col = col;
	}
	
	private void setRow(int row) {
		this.row = row;
	}
}
