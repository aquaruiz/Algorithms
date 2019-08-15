package longestIncreasingSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = bReader.readLine().split(" ");
		int[] input = Arrays.stream(inp).mapToInt(Integer::parseInt).toArray();
		int[] lengths = new int[input.length];
		int[] prevs = new int[input.length];  // stored by index
		
		int maxLen = 0;
		int lastKnownIndex = -1;
		
		for (int i = 0; i < input.length; i++) {
			lengths[i] = 1;
			prevs[i] = -1;
			
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i] && lengths[j] >= lengths[i]) {
					lengths[i] = 1 + lengths[j];
					prevs[i] = j;
				}
			}
			
			if (maxLen < lengths[i]) {
				maxLen = lengths[i];
				lastKnownIndex = i;
			}
		}
		
		bReader.close();
		
		// restore seq
		List<Integer> seq = restore(input, prevs, lastKnownIndex);
		System.out.println(seq.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
	
	public static List<Integer> restore(int[] sequence, int[] prevs, int lastKnownIndex) {
		List<Integer> longestSequence = new ArrayList<>();
		
		while (lastKnownIndex != -1) {
			longestSequence.add(sequence[lastKnownIndex]);
			lastKnownIndex = prevs[lastKnownIndex];
		}
		
		Collections.reverse(longestSequence);
		
		return longestSequence;
//		return longestSequence.toArray(Integer[]:: new);
	}
}