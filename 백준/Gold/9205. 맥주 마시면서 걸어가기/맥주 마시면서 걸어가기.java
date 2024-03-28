import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	
	public static Point end;
	public static Point [] position;
	
	public static int n;
	
	public static void main(String[] args) throws Exception{
		int test = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=test;tc++) {
			n = Integer.parseInt(br.readLine())+1;
			position = new Point[n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				position[i] = new Point(r,c);
			}
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			end = new Point(r,c);
			
			
			if(checking()) {
				sb.append("happy\n");
			}
			else
				sb.append("sad\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean checking() {
		Queue<Point> que = new ArrayDeque<>();
		boolean [] visited = new boolean[n];
		que.offer(position[0]);
		visited[0] = true;
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			
			if(Math.abs(end.r-now.r)+Math.abs(end.c-now.c)<=1000) {				
				return true;
			}
			
			for(int i=1;i<n;i++) {
				Point next = position[i];
				if(Math.abs(next.r-now.r)+Math.abs(next.c-now.c)<=1000&&!visited[i]) {
					que.offer(next);
					visited[i] = true;
				}
			}
		}
		return false;
	}
	
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}