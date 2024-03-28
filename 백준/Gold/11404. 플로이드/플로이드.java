import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static int node, edge;
	public static int[][] graph;
	public static int[][] answer;

	public static final int INF = 100000000;

	public static void main(String[] args) throws Exception {
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		graph = new int[node + 1][node + 1];
		
		for (int i = 1; i <= node; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start][end] = Math.min(weight, graph[start][end]);
		}
		
		floyd();
		
		for(int i=1;i<=node;i++) {
			for(int j=1;j<=node;j++) {
				if(graph[i][j]==INF) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(graph[i][j]+" ");
				}
			}System.out.println();
		}
	}

	public static void floyd() {

		for (int k = 1; k <= node; k++) {
			for (int i = 1; i <= node; i++) {
				for (int j = 1; j <= node; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}

}