import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static char[][] map;
	static boolean [][][] visited;
	
	static int row;
	static int col;
	static int answer = Integer.MAX_VALUE;
	
	static int dirR[] = {-1,1,0,0};
	static int dirC[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new char[row][col];
		visited = new boolean[row][col][2];
		
		for(int r=0;r<row;r++) {
			map[r] = br.readLine().toCharArray();
		}
		findload(new Point(0,0,1,1));
		if(answer == Integer.MAX_VALUE) answer = -1;
		
		System.out.println(answer);
		
	}
	
	public static void findload(Point start) {
		Queue<Point> que = new ArrayDeque<>();
		que.offer(start);
		visited[start.r][start.c][0]= true;
		visited[start.r][start.c][1]= true;
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			
			if(now.r == row-1 && now.c == col-1) {
				answer = Math.min(answer,now.cnt);
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nr = now.r+dirR[i];
				int nc = now.c+dirC[i];
				
				if(isIn(nr,nc)) continue;
				
				if(map[nr][nc]=='0') {
					if(visited[nr][nc][now.flag]) continue;
					visited[nr][nc][now.flag] = true;
					que.offer(new Point(nr,nc,now.flag,now.cnt+1));
				}
				else {
					if(now.flag==0) continue;
					if(visited[nr][nc][now.flag-1]) continue;
					visited[nr][nc][now.flag-1] = true;
					que.offer(new Point(nr,nc,now.flag-1,now.cnt+1));
				}
			}
		}
	}
	public static boolean isIn(int r,int c) {
		return r<0 || c<0 || r>=row || c>=col;
	}
	
	public static class Point{
		int r;
		int c;
		int flag;
		int cnt;
		public Point(int r, int c, int flag,int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.cnt = cnt;
		}		
	}

}