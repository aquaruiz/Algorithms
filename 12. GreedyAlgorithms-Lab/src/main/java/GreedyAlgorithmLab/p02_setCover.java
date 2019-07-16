package GreedyAlgorithmLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p02_setCover {
	private static final Charset ENCODING = Charset.forName("UTF-8");
    private static final String SEPARATOR = ", ";
    private static final String SETS_TAKEN = "Sets to take (%d):%n";
    private static final String ERROR = "No solution could be found";
	
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, ENCODING))) {

            int[] universe = Arrays
                    .stream(reader.readLine().substring(10).split(SEPARATOR))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            int numberOfSets = Integer.parseInt(reader.readLine().substring(16).trim());

            List<int[]> sets = new ArrayList<>();

            while (numberOfSets-- > 0) {
                sets.add(Arrays
                        .stream(reader.readLine().split(SEPARATOR))
                        .mapToInt(Integer::parseInt)
                        .toArray());
            }

            List<int[]> chosenSets = chooseSets(sets, universe);

            System.out.printf(SETS_TAKEN, chosenSets.size());

            chosenSets.forEach(s -> System.out
                    .println(Arrays.toString(s)
                            .replaceAll("\\[", "{ ")
                            .replaceAll("]", " }")));

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }


    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
    	 List<int[]> chosenSets = new ArrayList<>();

         Set<Integer> universeSet = Arrays
                 .stream(universe)
                 .boxed()
                 .collect(Collectors.toCollection(LinkedHashSet::new));

         Set<Integer> usedSetsIndexes = new HashSet<>();

         while (!universeSet.isEmpty()) {
             int bestIndex = -1;
             int bestMatches = 0;

             for (int currentIndex = 0; currentIndex < sets.size(); currentIndex++) {
                 if (usedSetsIndexes.contains(currentIndex)) {
                     continue;
                 }

                 int currentMatches = 0;
                 
                 for (int number : sets.get(currentIndex)) {
                     if (universeSet.contains(number)) {
                         currentMatches++;
                     }
                 }

                 if (currentMatches > bestMatches) {
                     bestMatches = currentMatches;
                     bestIndex = currentIndex;
                 }
             }

             if (bestIndex >= 0) {
                 usedSetsIndexes.add(bestIndex);

                 int[] set = sets.get(bestIndex);

                 chosenSets.add(set);

                 for (int number : set) {
                     universeSet.remove(number);
                 }
             } else {
                 throw new IllegalArgumentException();
             }
         }

         return chosenSets;
    }
}