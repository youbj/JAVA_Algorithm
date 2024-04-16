import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static ArrayList<Node>[] graph;
	private static int n, e, t;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, weight));
			graph[end].add(new Node(start, weight));
		}
		conquest();
	}

	public static int conquest() {
		boolean[] isVisited = new boolean[n + 1];
		PriorityQueue<Node> que = new PriorityQueue<Node>();

		que.offer(new Node(1, 0));

		int result = 0;
		int time = 0;
		while (!que.isEmpty()) {
			Node now = que.poll();

			if (isVisited[now.end])
				continue;
			isVisited[now.end] = true;
			if(now.weight!=0) {
				result += (now.weight + time * t);
				time++;
			}
			

			for (Node next : graph[now.end]) {
				if (!isVisited[next.end])
					que.offer(next);
			}
		}
		System.out.println(result);
		return result;
	}

	public static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", weight=" + weight + "]";
		}
		
	}
}