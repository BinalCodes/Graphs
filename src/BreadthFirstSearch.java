
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	GraphImplementation graph;
	BreadthFirstSearch(GraphImplementation graph){
		this.graph = graph;
	}
	public static void main(String[] args) {
		GraphImplementation graph = new GraphImplementation(5);
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		graph.addEdge(1,2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 0);
		graph.addEdge(4, 0);
		graph.addEdge(0, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 2);
		graph.printGraph();
		bfs.BFS(1,bfs.graph.v);

	}
	// print BFS from a given source
	public void BFS(int src, int numOfV) {
		boolean[] visited = new boolean[numOfV];
		Queue<Integer> queue = new LinkedList();
		queue.offer(src);
		visited[src] = true;
		while(!queue.isEmpty()) {
			int first = queue.poll();
			System.out.println(" "+first);
			List<Integer> list = graph.adjList[first];
			for(Integer e : list) {
				if(!visited[e]) {
					queue.add(e);
					visited[e] = true;
				}
			}
		}
	}

}
