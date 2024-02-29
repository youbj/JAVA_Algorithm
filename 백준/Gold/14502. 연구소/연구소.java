import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 
 * @date 	
 * @link	
 * @keyword_solution  
 * 최대 8*8 의 배열이니 원소가 64개 
 * 그 중 3개를 뽑는 다면 최대 41600 언저리 
 * @input 
 * 
 * @output   
 * 
 * @time_complex  
 * 
 * @perf 
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int row, col;
	static int [][] map;
	static boolean [] selected;
	static Point[] walls = new Point[3];
	static ArrayList<Point> birus;
	static ArrayList<Point> normal;
	static int max = Integer.MIN_VALUE;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		Init();
		combi(0,0);
		System.out.println(max);
	}
	
	public static void bfs() {
		int [][] clonemap = new int[row][col];
		
		for(int r=0;r<row;r++) {
			clonemap[r] = map[r].clone();
		}
		
		for(int i=0;i<3;i++) {
			clonemap[walls[i].r][walls[i].c] = 1;
		}
		
		Queue<Point> que = new ArrayDeque<>();
		boolean [][] visited = new boolean [row][col];
		
		for(int i=0;i<birus.size();i++) {
			que.offer(birus.get(i));
		}
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			visited[now.r][now.c] = true;
			
			for(int i=0;i<4;i++) {
				int nr = now.r +dr[i];
				int nc = now.c +dc[i];
				
				if(isIn(nr,nc)) continue;
				if(visited[nr][nc] || clonemap[nr][nc] == 1) continue;
				
				clonemap[nr][nc] = 2;
				visited[nr][nc] = true;
				que.offer(new Point(nr,nc));
			}
		}
		max = Math.max(max, countNum(clonemap));
	}
	
	public static int countNum(int[][] clonemap) {
		int count=0;
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(clonemap[r][c]==0) count++;
			}
		}
		return count;
	}
	
	public static boolean isIn(int r, int c) {
		return r<0 || c<0 || r>=row || c>=col;
	}
	
	public static void combi(int cnt, int start) {
		if(cnt==3) {			
			bfs();
			return;
		}
		
		for(int i = start;i<normal.size();i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			walls[cnt] = normal.get(i);
			combi(cnt+1,i+1);
			selected[i] = false;
		}
		
	}
	
	public static void Init() throws IOException{
		st =new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		birus = new ArrayList<>();
		normal = new ArrayList<>();
		
		for(int r=0;r<row;r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==0) {
					normal.add(new Point(r,c));
					continue;
				}
				
				if(map[r][c] == 2)
					birus.add(new Point(r,c));
			}
		}
		selected = new boolean[normal.size()];
	}

	public static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	
}