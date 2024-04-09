import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static int row, col;
	public static char[][] map;
	public static boolean [][][]visited; 
	public static Point start;
	public static int answer = Integer.MAX_VALUE;

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		init();
		answer = bfsPath();
		System.out.println(answer);
	}
	
	public static int bfsPath() {
		Queue<Point> que = new ArrayDeque<>();
		que.offer(start);
		visited[start.r][start.c][start.key] = true;
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			if(map[now.r][now.c]=='1') {
				return now.cnt;
			}
			
			for(int i=0;i<4;i++) {
				int nr = now.r+dr[i];
				int nc = now.c+dc[i];
				
				if(isIn(nr,nc)||visited[nr][nc][now.key]) continue;
				
				if(map[nr][nc]>='a'&&map[nr][nc]<='f') {
					que.offer(new Point(nr,nc,now.key|(1<<(map[nr][nc]-'a')),now.cnt+1));
					visited[nr][nc][now.key|(1<<(map[nr][nc]-'a'))] = true;
				}
				else if(map[nr][nc]>='A'&&map[nr][nc]<='F') {
					if((now.key & (1 << (map[nr][nc] - 'A'))) != 0) {
						que.offer(new Point(nr,nc,now.key,now.cnt+1));
						visited[nr][nc][now.key] = true;
					}
				}
				else {
					que.offer(new Point(nr,nc,now.key,now.cnt+1));
					visited[nr][nc][now.key] = true;
				}
			}
		}
		
		return -1;
	}

	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new char[row][col];
		visited = new boolean[row][col][65];
		
		for (int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < col; c++) {
				if (map[r][c] == '0') {
					start = new Point(r, c,0, 0);
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r < 0 || c < 0 || r >= row || c >= col|| map[r][c]=='#';
	}

	public static class Point {
		int r;
		int c;
		int key;
		int cnt;

		public Point(int r, int c,int key,int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
}