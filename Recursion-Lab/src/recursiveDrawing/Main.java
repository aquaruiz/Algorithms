package recursiveDrawing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		printFigure(n);
	}

	public static void printFigure(int n) {
		if (n == 0) {
			return;
		}
		
		// pre-action print n asterisks
		System.out.println(new String(new char[n]).replace("\0", "*"));

		// recursive call : print figure of size n-1
		printFigure(n - 1);
		
//		 post-action : print n hashtags
		System.out.println(new String(new char[n]).replace("\0", "#"));
	}
}
