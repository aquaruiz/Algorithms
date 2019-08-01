package words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	static char[] letters;
	static Set<String> words;
	static Map<Integer, Boolean> used = new TreeMap<Integer, Boolean>();
	
	public static void main(String[] args) throws IOException {
		letters = readInput();
		
		words = new HashSet<>();

		generateWords();

		System.out.println(words.size());
//		printOutput();
	}

	private static void generateWords() {
		String[] word = new String[letters.length];
		
		for (int i = 0; i < letters.length; i++) {
			used.put(i, false);
		}
		
		makeWord(word, 0);
	}

	private static void makeWord(String[] word, int index) {
		if (index >= letters.length) {
			for (int i = 1; i < word.length; i++) {
				if(word[i-1].equals(word[i])) {
					return;
				}
			}
			
			words.add(String.join("", word));
			return ;
		}
		
		for (int i = 0; i <  letters.length; i++) {
			if (!used.get(i)) {
				word[index] = "" + letters[i];
				used.put(i, true);
				makeWord(word, index + 1);
				used.put(i, false);
			}
		}
	}

	private static char[] readInput() throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = bReader.readLine().toCharArray();
		return input;
	}

	private static void printOutput() {
		System.out.println(
					words.stream()
							.map(p -> String.join("", p))
							.collect(Collectors.joining(System.lineSeparator()))
				);
	}
}