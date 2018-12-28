import java.util.List;

public class DepthFirstSearch {
	GraphImplementation graph;
	public DepthFirstSearch(GraphImplementation graph) {
		this.graph = graph;
	}
	public static void main(String[] args) {
		GraphImplementation graph = new GraphImplementation(5);
		graph.addEdge(1,2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 0);
		graph.addEdge(4, 0);
		graph.addEdge(0, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 2);
		graph.printGraph();
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		dfs.DFS(1);

	}
	public void DFS(int src) {
		boolean[] visited = new boolean[graph.v];
		if(!visited[src]) {
			DFSUtil(src, visited);
		}
	}
	public void DFSUtil (int src, boolean[] visited) {
		System.out.println(" "+src);
		visited[src] = true;
		List<Integer> list = graph.adjList[src];
		for(Integer i : list) {
			if (!visited[i])
				DFSUtil(i, visited);
		}
	}

}
