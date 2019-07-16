package cubes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static Set<Cube> isomorphicCubes;
    public static int[] currentEdges;
    public static int[] colorsLeftCount;
    public static int cubesCount;

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int[] sticks = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        scanner.close();
        
        int count = numberOfCubes(sticks);
        System.out.println(count);
    }

    public static void generateCubes(int edgeIndex) {
        if (edgeIndex == Cube.EDGE_COUNT) {
            Cube cube = new Cube(currentEdges);
            if (isomorphicCubes.contains(cube)) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                cube.RotateXY();
                for (int j = 0; j < 4; j++) {
                    cube.RotateXZ();
                    for (int k = 0; k < 4; k++) {
                        cube.RotateYZ();
                        isomorphicCubes.add(new Cube(cube));
                    }
                }
            }

            cubesCount++;
//            System.out.println(cube);
            return;
        }

        for (int color = 1; color <= Cube.MAX_COLOR; color++) {
            if (colorsLeftCount[color] > 0) {
                colorsLeftCount[color]--;
                currentEdges[edgeIndex] = color;
                generateCubes(edgeIndex + 1);
                colorsLeftCount[color]++;
            }
        }
    }

    public static int numberOfCubes(int[] sticks) {
        colorsLeftCount = new int[Cube.MAX_COLOR + 1];
        
        for (int i = 0; i < Cube.EDGE_COUNT; i++) {
            colorsLeftCount[sticks[i]]++;
        }

        currentEdges = new int[Cube.EDGE_COUNT];
        isomorphicCubes = new HashSet<Cube>();
        cubesCount = 0;
        generateCubes(0);

        return cubesCount;
    }

    public static class Cube implements Comparable<Cube>{
        public final static int EDGE_COUNT = 12;
        public final static int MAX_COLOR = 6;
        public int[] edges;

        public Cube() {
            this.edges = new int[EDGE_COUNT];
        }

        public Cube(int[] newEdges) {
        	System.arraycopy(newEdges, 0, this.edges, 0, EDGE_COUNT);
        }

        public Cube(Cube cube) {
        	System.arraycopy(cube.edges, 0, this.edges, 0, EDGE_COUNT);
        }

        @Override
        public String toString() {
            String s = "{";

            for (int edge : this.edges) {
                s += edge;
            }
            
            s += "}";
            return s;
        }

        public void RotateXY() {
            int[] newEdges =
            	{
                    this.edges[1], this.edges[2], this.edges[3], this.edges[0],
                    this.edges[5], this.edges[6], this.edges[7], this.edges[4],
                    this.edges[9], this.edges[10], this.edges[11], this.edges[8]
                };

            this.edges = newEdges;
        }

        public void RotateXZ() {
            int[] newEdges =
            {
                    this.edges[4], this.edges[9], this.edges[5], this.edges[1],
                    this.edges[8], this.edges[10], this.edges[2], this.edges[0],
                    this.edges[7], this.edges[11], this.edges[6], this.edges[3]
                };

            this.edges = newEdges;
        }

        public void RotateYZ() {
            int[] newEdges =
            {
                    this.edges[2], this.edges[5], this.edges[10], this.edges[6],
                    this.edges[1], this.edges[9], this.edges[11], this.edges[3],
                    this.edges[0], this.edges[4], this.edges[8], this.edges[7]
                };

            this.edges = newEdges;
        }

        @Override
        public boolean equals(Object obj)
        {
            Cube cube = (Cube) obj;
            if (cube != null) {
                for (int i = 0; i < Cube.EDGE_COUNT; i++) {
                    if (this.edges[i] != cube.edges[i]) {
                        return false;
                    }
                }

                return true;
            }

            return false;
        }

        public int getHashCode() {
            int hashCode = 0;
            for (int edge : this.edges) {
                hashCode = hashCode * 7 + edge;
            }

            return hashCode;
        }

		@Override
		public int compareTo(Cube o) {
			// TODO Auto-generated method stub
			return 0;
		}
    }
}
