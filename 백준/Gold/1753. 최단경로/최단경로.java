import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int node;
	static int edge;
	static int startNode;
	static final int INF = Integer.MAX_VALUE;
	
	static ArrayList<Edge>[] graph;
	static int [] list;

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[node+1];
		for(int i=0;i<=node;i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		list = new int[node+1];
		Arrays.fill(list, INF);
		
		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[node1].add(new Edge(node2,weight));
		}
		dijkstra(new Edge(startNode,0));
		for(int i=1;i<=node;i++) {
			if(list[i]==INF) {
				System.out.println("INF");
				continue;
			}
			System.out.println(list[i]);
		}
	}
	
	public static void dijkstra(Edge e) {
		PriorityQueue<Edge> que = new PriorityQueue<>();
		que.offer(e);
		list[e.node]=0;
		
		while(!que.isEmpty()) {
			Edge now = que.poll();
			
			if(list[now.node]<now.weight) continue;
			
			for(Edge next: graph[now.node]) {
				if(list[next.node]>now.weight +next.weight) {
					list[next.node] = now.weight+next.weight;
					que.offer(new Edge(next.node,list[next.node]));
				}
			}
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int node;
		int weight;
		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}		
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
}