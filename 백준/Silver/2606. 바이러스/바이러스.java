import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static boolean [][] graph;
	static int comNum;
	public static void main(String[] args) throws Exception{
		comNum = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		graph = new boolean[comNum][comNum];
		
		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b]=true;
			graph[b][a]=true;
		}
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer>que = new ArrayDeque<Integer>();
		boolean [] birus = new boolean [comNum];
		int cnt=0;
		
		que.offer(0);
		birus[0]=true;
		
		while(!que.isEmpty()) {
			int current = que.poll();
			for(int i=0;i<comNum;i++) {
				if(graph[current][i] && !birus[i]) {
					que.offer(i);
					birus[i]=true;
				}
			}
		}
		for(boolean check:birus) {
			if(check) cnt++;
		}
		System.out.println(cnt-1);
	}
}