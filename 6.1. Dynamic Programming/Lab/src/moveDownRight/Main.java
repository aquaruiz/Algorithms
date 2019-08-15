package moveDownRight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] matrix;
	static int[][] path;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int xSize = Integer.parseInt(bReader.readLine());
		int ySize = Integer.parseInt(bReader.readLine());
		
		matrix = new int[xSize][ySize];
		
		for (int i = 0; i < xSize; i++) {
			int[] input = Arrays.stream(bReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < ySize; j++) {
				matrix[i][j] = input[j];
			}
		}
		
		
		bReader.close();
		
		path = Arrays.copyOf(matrix, matrix.length);
		
		findPath();
		// down, right
		
		String output = generatePathString();
		
		System.out.println(output);
	}

	private static String generatePathString() {
		StringBuilder sb = new StringBuilder();
        int x = path.length - 1;
        int y = path[0].length - 1;
        
        while (x >= 0 && y >= 0) {
            sb.insert(0, String.format("[%d, %d] ", x, y));
            
            if (x == 0) {
                y--;
                continue;
            }
            
            if (y == 0) {
                x--;
                continue;
            }
            
            if (path[x - 1][y] > path[x][y - 1]) {
                x--;
            } else {
                y--;
            }
        }
        
        return sb.toString();
	}

	private static void findPath() {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					path[0][0] = path[0][0];
				} else if (i == 0) {
					path[i][j] = path[i][j] + path[i][j - 1];
				} else if (j == 0) {
					path[i][j] = path[i][j] + path[i - 1][j];
				} else {
					path[i][j] = path[i][j] + Math.max(path[i - 1][j], path[i][j - 1]);
				}
			}
		}
		
		System.out.println();
		
	}

}
