package fibonacciRecursevly;

public class Main {

	public static void main(String[] args) {
//		System.out.println(fibonacci(11));
		System.out.println(fibonacci(50));
	}

	private static float fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} 
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
