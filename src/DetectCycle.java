

public class DetectCycle {
	DirectedAcyclicGraph graph;
	public DetectCycle(DirectedAcyclicGraph graph) {
		this.graph = graph;
	}
	public static void main(String[] args) {
		DirectedAcyclicGraph graph = new DirectedAcyclicGraph(4);
		graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3);
        DetectCycle dc = new DetectCycle(graph);
        System.out.println("Cycles in this graph "+dc.iscyclic());
	}
	public boolean iscyclic () {
		boolean[] visited = new boolean[graph.v];
		boolean[] recStack = new boolean[graph.v];
		for(int i =0 ; i< graph.v ; i++) {
			visited[i] = false;
			recStack[i] = false;
		}
		for(int i =0 ; i< graph.v ; i++) {
			if(isCyclicUtil(i,visited,recStack))
				return true;
		}
		return false;
	}
	public boolean isCyclicUtil(int v , boolean[] visited , boolean[] recStack) {
		
		if(recStack[v])
			return true;
		if(visited[v])
			return true;
		
		visited[v] = true;
		recStack[v] = true;
		for(Integer i : graph.adjList[v]) {
			if(!visited[i])
				isCyclicUtil(i, visited, recStack);
		}
		recStack[v] = false;
		return false;
	}

}
