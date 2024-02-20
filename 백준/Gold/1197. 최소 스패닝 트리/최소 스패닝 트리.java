import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int node;
	static int edge;
	static ArrayList<Edge>[] Nodes;

	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		
		node= Integer.parseInt(st.nextToken());
		edge= Integer.parseInt(st.nextToken());
		
		Nodes=new ArrayList [node+1];
		
		for(int i=1;i<=node;i++) {
			Nodes[i]= new ArrayList<Edge>();
		}

		
		for(int i=0;i<edge;i++) {
			st= new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Nodes[startNode].add(new Edge(endNode,weight));
			Nodes[endNode].add(new Edge(startNode,weight));
		}
		makeSpanningTree();
	}
	
	public static void makeSpanningTree() {
		PriorityQueue<Edge> que = new PriorityQueue<>();
		boolean [] visited= new boolean[node+1];
		
		for(Edge node:Nodes[1]) {
			que.offer(node);
		}
		visited[1]= true;
		
		int sum =0;
		while(!que.isEmpty()) {
			Edge current = que.poll();
			if(visited[current.endNode])
				continue;
			else {
//				System.out.print(current);
				sum+=current.weight;
				visited[current.endNode]=true;
				for(Edge node:Nodes[current.endNode]) {
					if(!visited[node.endNode])
						que.offer(node);
				}
			}
		}
		System.out.println(sum);
	}
	
	public static class Edge implements Comparable<Edge>{
		int endNode;
		int weight;
		
		Edge(int endNode,int weight){
			this.endNode=endNode;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {		
			return Integer.compare(this.weight, o.weight);
		}
	}

}