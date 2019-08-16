package connectedComponents;
import java.util.*;

public class Main {
	private static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) {
        graph = readGraph();
        
        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        
        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.println(connectedComponent);
        }
    }

    private static List<List<Integer>> readGraph() {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
 
        for (int i = 0; i < n; i++) {
            List<Integer> connectedComponents = new ArrayList<>();

            String line = scanner.nextLine();
            
            if (line.equals("")) {
                graph.add(connectedComponents);
                continue;
            }
        
            String[] nodes = line.split(" ");

            for (String node : nodes) {
                connectedComponents.add(Integer.parseInt(node));
            }

            graph.add(connectedComponents);
        }
        
        return graph;
    }

    
    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
    	List<Deque<Integer>> connectedComponents = new ArrayList<>();
    	visited = new boolean[graph.size()];

    	for (int i = 0; i < graph.size(); i++) {
    		if (!visited[i]) {
				System.out.print("Connected component:");
				dfs(i);
				System.out.println();
			}
		}

    	return connectedComponents;
    }
    
    private static void dfs(int vertex) {
		if (!visited[vertex]) {
			visited[vertex] = true;
			for (int child : graph.get(vertex)) {
				dfs(child);
			}
			
			System.out.print(" " + vertex);
		}
	}
}