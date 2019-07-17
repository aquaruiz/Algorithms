package recursiveDrawing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("How big figure do you want to draw: ");
		int num = 0;
		try {
			num = Integer.parseInt(bReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Something went wrong ;`(");
		}
		
		drawThatBig(num); 
	}

	private static void drawThatBig(int num) {
		if (num == 0) {
			return;
		}
		
//		pre-recursive behavior
		System.out.println(new String(new char[num]).replace('\0', '*'));
		
		drawThatBig(num - 1);
		
//		post- recursive behavior
		System.out.println(new String(new char[num]).replace('\0', '#'));
	}

}