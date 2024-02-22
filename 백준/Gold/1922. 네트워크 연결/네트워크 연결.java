import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	static int V;
	static Edge[] edgeList;
	static int [] parent;
	
	public static void main(String[] args) throws Exception{
//		st =new StringTokenizer(br.readLine());
//		V = Integer.parseInt(st.nextToken());
//		int E =  Integer.parseInt(st.nextToken());
//		
		V= Integer.parseInt(br.readLine());
		int E= Integer.parseInt(br.readLine());
		edgeList = new Edge[E];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight =Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		} // 간선 리스트 생성
		
		//전처리 : 간선 리스트 오름차순 정렬
		Arrays.sort(edgeList);
		
		//1. make Set
		makeSet();
		
		//2. 정렬된 간선 하나씩 꺼내어 신장트리 생성
		int weight=0;
		int cnt=0;
		for(Edge edge:edgeList) {
			if(!Union(edge.from, edge.to)) continue;
			weight +=edge.weight;
			if(++cnt == V-1) break;
		}
		System.out.println(weight);
	}
	
	private static void makeSet() {
		parent = new int[V+1]; // 자신의 부모나 루트를 저장(경로 압축으로 인해)
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) { // a가 속한 트리의 루트 찾기
		if(parent[a] ==a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	private static boolean Union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA==rootB)
			return false; // 이미 A와 B가 같은 루트를 가진다 = 같은 트리에 속하다. = Union 필요 X
		else {
			parent[rootB] = rootA;
			return true;
		}
	}
	
}