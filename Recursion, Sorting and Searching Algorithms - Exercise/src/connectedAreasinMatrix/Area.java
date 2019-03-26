package connectedAreasinMatrix;

public class Area implements Comparable<Area> {
	private int row;
	private int col;
	private int size;
	
	public Area(int row, int col, int size) {
		this.setRow(row);
		this.setCol(col);
		this.setSize(size);
	}

	public int getCol() {
		return col;
	}
	
	private void setCol(int col) {
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	private void setRow(int row) {
		this.row = row;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int compareTo(Area other) {
		if (this.size != other.size) {
			return other.size - this.size;
		}
		
		if (this.row != other.row) {
			return this.row - other.row;
		}
		
		return this.col - other.col;
	}
}