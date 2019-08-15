package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<Long> fibs = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bReader.readLine());
		
		long fibon = fib(n);
		System.out.println(fibon);
	}

	private static long fib(int n) {
		fibs = new ArrayList<>(Collections.nCopies(n, null));
		fibs.set(0, 1l);
		fibs.set(1, 1l);
		return getFib(n - 1) + getFib(n - 2);
	}

	private static long getFib(int n) {
		if (n == 0) {
			return 0;
		}
		
		if (n == 2 || n == 1) {
			return 1;
		}
		
		if (fibs.get(n) != null) {
			return fibs.get(n);
		} else {
			long f = getFib(n - 1) + getFib(n - 2);
			fibs.set(n, f);
			return f;
		}
	}
}