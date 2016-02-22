package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class graph{
	private final int v;
	private List<Integer> []adj;
	public graph(int v){ // create a graph with V vertices;
		this.v = v;
		adj = (List<Integer>[])new List[v];
		for(int i = 0;i<v;i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	public void addEdges(int v,int w){ // add edge v-w
		adj[v].add(w);
		adj[w].add(v);
	}
	public Iterable<Integer> adj(int v){ // vertices adjacent to v
		return adj[v];
	}
    public int V(){ // numbers of vertices
    	return v;
    }
    public int E(){ // numbers of edges
    	int count = 0;
    	for(int i =0;i<v;i++){
    		for( int w:adj(i)){
    			count++;
    		}
    	}
    	return count/2;
    }
}
    

public static int degree(graph G,int v){
	int count = 0;
	for(int w : G.adj(v)){
		count ++;
	}
	return count;
}

public static int maxDegree( graph G ){
	int max = 0;
	for(int i=0; i < G.V(); i++){
		if(degree(G,i) > max){
			max = degree(G,i);
		}
	}
	
	return max;
}

public static double averageDegree( graph G){
	return 2 * G.E() / G.V() ; 
}

public static int numberOfSelfLoop(graph G){
	int count = 0;
	for(int v = 0; v < G.V() ; v++ ){
		for(int w: G.adj(v)){
			if(w==v){
				count++;
			}
		}
	}
	return count;
}

public class DepthFirstPaths{
	private boolean[] visited;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstPaths(graph G, int s){
		visited = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		
		dfs(G,s);
	}
	
	private void dfs(graph G,int v){
		visited[v] = true;
		for(int i : G.adj(v) ){
			if(visited[i]==false){
				edgeTo[i] = v;
				dfs(G,i);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return visited[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if( !hasPathTo(v) ){
			return null;
		} 
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = egdeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
}

public class BreadthFirstPaths{
	private boolean[] visited;
	private int[] edgeTo;
	private int s;
	
	public BreadthFirstPaths(graph G, int s){
		visited = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		
		bfs(G,s);
	}
	
	private void bfs(graph G,int v){
		Queue<Integer> q = new LinkedList<Integer>();
		visited[v] = true;
		q.add(v);
		while( !q.isEmpty() ){
			int x = q.remove();
			for( int w:G.adj(x) ){
				if( !visited[w] ){
					q.add(w);
					visited[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}
	
}

public class componentContain{
	private boolean[] visited;
	private int[] id;
	private int count;
	 
	public componentContain(graph G){
		visited = new boolean[G.V()];
		id = new int[G.V()];
		count = 0;
		for( int i=0; i<G.V(); i++){
			if( !visited[i] ){
				dfs(G,i);
				count++;
			}
		}
	}
	
	private void dfs(graph G,int v){
		visited[v] = true;
		id[v] = count;
		for(int i : G.adj(v)){
			if( !visited[i] ){
			dfs(G,i);
			}
		}
	}
	
	public int count(){
		return count;
	}
	
	public int id(int v){
		return id[v];
	}
	
	
	
	
}

public class undirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
