package needles2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] cn = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
        		.map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        int[] needles = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isFound = false;
        
        for (int number : needles) {
			for (int i = 0; i < numbers.size(); i++) {
				
				if (numbers.get(i) >= number) {
					if (i > 0 && numbers.get(i - 1) == 0) {
						for (int j = i - 1 ; j >=  0; j--) {
							if (numbers.get(j) == 0) {
								continue;
							} else {
								System.out.print(j + 1 + " ");
								break;
							}
						}
					} else {
						System.out.print(i + " ");
					}
					
					isFound = true;
					break;
				} 
				
			}
			
			if (!isFound && number > numbers.get(numbers.size() - 1)) {
				System.out.print(numbers.size() + " ");
				isFound = true;
			}
			
			if (!isFound) {
				System.out.print(0 + " ");				
			}
		}
	}
}