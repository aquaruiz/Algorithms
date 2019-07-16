package needles;

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

        scanner.close();
        
        int prev = numbers.get(cn[0] - 1);
        
        for (int i = cn[0] - 1; i >= 0; i--) {
            if (numbers.get(i) == 0) {
                numbers.set(i, prev);
            }

            prev = numbers.get(i);
        }

        List<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < cn[1]; i++) {
            boolean isIn = false;
            
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) >= needles[i]) {
                    result.add(j);
                    isIn = true;
                    break;
                }
            }

            if (!isIn) {
                int index = numbers.size() - 1;
                while (index > 0 && numbers.get(index) == 0) {
                    index--;
                }
                
                if (numbers.get(index) == 0)  {
                    index--;
                }
                
                result.add(index + 1);
            }
        }

        System.out.println(result.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
    }
}