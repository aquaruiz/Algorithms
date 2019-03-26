package words;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static int counter = 0;
    private static int count;
    
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	char[] word = scanner.nextLine().toCharArray();
    	Arrays.sort(word);
    	
        count = word.length;
        boolean noRepetition = isValid(word);
        if (noRepetition) {
            int result = calculateFactorial(count);
            System.out.println(result);
            return;
        }

        permutate(word, 0, word.length);
        System.out.println(counter);
    }

    private static int calculateFactorial(int count) {
        int factorial = 1;
        for (int i = 2; i <= count; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private static boolean isValid(char[] word) {
        for (int i = 1; i < count; i++) {
            if (word[i] == word[i - 1]) {
                return false;
            }
        }

        counter++;
        return true;
    }

    private static void permutate(char[] word, int start, int n) {
        if (start >= n) {
        	return;
        }

        for (int i = n - 2; i >= start; i--) {
            for (int j = i + 1; j < n; j++) {
                if (word[i] != word[j]) {
                    word = swap(word, i, j);
                    isValid(word);
                    permutate(word, i + 1, n);
                }
            }

            char tmp = word[i];
            for (int k = i; k < n - 1;) {
                word[k] = word[++k];
            }

            word[n - 1] = tmp;
        }
    }

    private static char[] swap(char[] word, int i, int j) {
        if (word[i] == word[j]) {
            return word;
        }

        word[i] ^= word[j];
        word[j] ^= word[i];
        word[i] ^= word[j];
        
        return word;
    }
}