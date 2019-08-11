package cubes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static String[] cube;
    private static Set<String> used = new HashSet<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cube = reader.readLine().split(" ");
        
        generatePermutations(0);
        System.out.println(count);
    }

    private static void generatePermutations(int index) {
        if (index == cube.length) {
            String permutation = String.join("", cube);
            
            if (!used.contains(permutation)) {
                count++;
                addAllRotations();
            }
            
            return;
        }
        
        Set<String> swapped = new HashSet<>();
        
        for (int i = index; i < cube.length; i++) {
            if (!swapped.contains(cube[i])) {
                swap(index, i);
                generatePermutations(index + 1);
                swap(index, i);
                swapped.add(cube[i]);
            }
        }
    }

    private static void swap(int i, int j) {
        String temp = cube[i];
        cube[i] = cube[j];
        cube[j] = temp;
    }

    private static void addAllRotations() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String rotation = String.join("", cube);
                used.add(rotation);
                rotateHorizontal();
            }
            
            rotateVertical();
        }
        
        rotateHorizontal();
        rotateVertical();
        
        for (int i = 0; i < 4; i++) {
            String rotation = String.join("", cube);
            used.add(rotation);
            rotateHorizontal();
        }
        
        rotateVertical();
        rotateVertical();
        
        for (int i = 0; i < 4; i++) {
            String rotation = String.join("", cube);
            used.add(rotation);
            rotateHorizontal();
        }
    }

    private static void rotateHorizontal() {
        String[] temp = new String[cube.length];
        temp[0] = cube[10];
        temp[1] = cube[4];
        temp[2] = cube[0];
        temp[3] = cube[9];
        temp[4] = cube[5];
        temp[5] = cube[6];
        temp[6] = cube[1];
        temp[7] = cube[2];
        temp[8] = cube[3];
        temp[9] = cube[11];
        temp[10] = cube[7];
        temp[11] = cube[8];
        cube = temp;
    }

    private static void rotateVertical() {
        String[] temp = new String[cube.length];
        temp[0] = cube[9];
        temp[1] = cube[3];
        temp[2] = cube[8];
        temp[3] = cube[11];
        temp[4] = cube[0];
        temp[5] = cube[1];
        temp[6] = cube[2];
        temp[7] = cube[6];
        temp[8] = cube[7];
        temp[9] = cube[10];
        temp[10] = cube[4];
        temp[11] = cube[5];
        cube = temp;
    }
}