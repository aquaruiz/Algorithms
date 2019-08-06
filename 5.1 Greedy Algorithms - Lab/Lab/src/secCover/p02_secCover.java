//package secCover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_secCover {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(in.nextLine().substring(16));
        
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = in.nextLine().trim().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            
            sets.add(set);
        }

        in.close();

        List<int[]> choosenSets = chooseSets(sets, universe);
        printOutput(choosenSets);
    }

	public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
		List<int[]> setsToWorkWith = new ArrayList<>();
		for (int[] is : sets) {
			setsToWorkWith.add(Arrays.copyOf(is, is.length));
		}
		
    	List<int[]> setToTake = new ArrayList<>();
    	
    	while (universe.length > 0) {
    		orderByElementsInUniverseCountDesc(setsToWorkWith, universe);
    		
    		setToTake.add(setsToWorkWith.get(0));
    		int[] deleted = setsToWorkWith.remove(0);
    		List<Integer> deletedList = Arrays.stream(deleted)
    				.boxed()
    				.collect(Collectors.toList());
    		
    		universe = Arrays.stream(universe)
    			.filter(el ->  !deletedList.contains(el))
    			.toArray();
		}
    	
        return setToTake;
    }

	private static void orderByElementsInUniverseCountDesc(List<int[]> setsToWorkWith, int[] universe) {
		Comparator<int[]> sortedByElementCount = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int countO1 = 0;
				int countO2 = 0;

				for (int i = 0; i < universe.length; i++) {
					int currentElement = universe[i];
					if (Arrays.stream(o1)
							.boxed()
							.collect(Collectors.toList())
							.contains(currentElement)) {
						countO1++;
					}
					
					if (Arrays.stream(o2)
							.boxed()
							.collect(Collectors.toList())
							.contains(currentElement)) {
						countO2++;
					}
				}
				
				if (countO1 - countO2 == 0) {
					return o1.length - o2.length;
				}
				
				return countO2 - countO1;
			}
		};
		
		Collections.sort(setsToWorkWith, sortedByElementCount);		
	}

	private static void printOutput(List<int[]> choosenSets) {
		System.out.println(String.format("Sets to take (%d):", choosenSets.size()));
		
		choosenSets.stream()
		.forEach(set -> System.out.println(
				String.format("{%s}", 
						Arrays.stream(set).mapToObj(String::valueOf)
								.collect(Collectors.joining(", ")))
			));
	}
}
