import java.util.Stack;

public class TopologicalSort {
	DirectedAcyclicGraph graph;
	public TopologicalSort(DirectedAcyclicGraph graph) {
		this.graph = graph;
	}
	public static void main(String[] args) {
		DirectedAcyclicGraph graph = new DirectedAcyclicGraph(6);
		graph.addEdge(5,2);
		graph.addEdge(5,0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.printGraph();
		TopologicalSort ts = new TopologicalSort(graph);
		ts.topologicalSort();
	}
	
	public void topologicalSort () {
		Stack<Integer> stack = new Stack();
		
		boolean[] visited = new boolean[graph.v];
		for(int i =0 ; i< graph.v ; i++) {
			visited[i] = false;
		}
		for(int i =0 ; i< graph.v ; i++) {
			if(!visited[i]) {
				tsUtil(i,visited,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.println(" "+stack.pop());
		}
	}
	public void tsUtil(int i , boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		for(Integer v : graph.adjList[i]) {
			if(!visited[v])
				tsUtil(v, visited, stack);
		}
		stack.push(i);
	}
	
}
