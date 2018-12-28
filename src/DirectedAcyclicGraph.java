import java.util.LinkedList;
import java.util.List;
/*
 * This is a Java representation of undirected graph class using adjacency list
 * 
 */
public class DirectedAcyclicGraph {
	int v;
	List<Integer>[] adjList;
	boolean[][] adjMatrix;
	DirectedAcyclicGraph(int v){
		this.v = v;
		adjList = new LinkedList[v];
		adjMatrix = new boolean[v][v];
		for(int i =0 ;i <v; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	public static void main(String[] args) {
		DirectedAcyclicGraph graph = new DirectedAcyclicGraph(5);
		graph.addEdge(1,2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 0);
		graph.addEdge(4, 0);
		graph.addEdge(0, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 2);
		graph.printGraph();
		graph.printAdjMatrixGraph();
		graph.removeEdge(1, 0);
		graph.printGraph();
		graph.printAdjMatrixGraph();
	}
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
		adjMatrix[src][dest] = true;
	}
	
	public void removeEdge (int src, int dest) {
		if (adjMatrix[src][dest]) adjMatrix[src][dest] = false;
		/*List<Integer> list =adjList[src];
		for(Integer i : list) {
			if(i == dest)
				adjList[src].remove(i);
		}
		Iterator<Integer> it = adjList[dest].iterator();
		while(it.hasNext()) {
			int i = it.next();
			if(i == src)
				adjList[dest].remove(i);
		}
		*/
	}
	
	public void printGraph() {
		for(int i =0 ; i<v ;i++) {
			List<Integer> edges = adjList[i];
			System.out.print("Vertex "+i +" has edges ");
			for(Integer e : edges)
				System.out.print(e+" ");
			System.out.println();
		}
	}
	
	public void printAdjMatrixGraph() {
		for(int i =0 ; i<v ;i++) {
			System.out.print(" "+i+":");
			for(int j = 0 ; j <v ; j++) {
				System.out.print(adjMatrix[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}
	}

}
