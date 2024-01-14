//package swea_1249;
//
//import java.io.*;
//import java.util.*;
//
//class point{
//	int x;
//	int y;
//	public point(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//	
//}
//public class SWEA_1249 {
//	static int N,ans;
//	static boolean[][] visited;
//	static int[][] map;
//	static int[][] count;
//	static int[] dx= {-1,1,0,0};
//	static int[] dy= {0,0,-1,1};
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int testCase = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= testCase; tc++) {
//			N = Integer.parseInt(br.readLine());
//			
//			ans = Integer.MAX_VALUE;
//			map = new int[N][N];
//			count = new int[N][N];
//			visited = new boolean[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				String temp = br.readLine();
//				for (int j = 0; j < N; j++) {
//					map[i][j] = temp.charAt(j)-'0';
//				}
//			}
//			for (int i = 0; i < N; i++) {				
//				Arrays.fill(count[i], Integer.MAX_VALUE);
//			}
//			count[0][0]=0;
//			
//			bfs();
//			sb.append("#"+tc+" "+ans+"\n");
//		}
//		System.out.println(sb);
//	}
//	private static void bfs() {
//		Queue<point> q = new LinkedList<>();
//		q.add(new point(0,0));
//		visited[0][0] = true;
//		while(!q.isEmpty()) {
//			point cur = q.poll();
//			
//			if(cur.x ==N-1 && cur.y==N-1) {
//				ans = ans > count[N-1][N-1]?count[N-1][N-1]:ans;
//			}
//			
//			for (int k = 0; k < 4; k++) {
//				int nx = cur.x + dx[k];
//				int ny = cur.y + dy[k];
//				if(nx<0||nx>=N||ny<0||ny>=N)continue;
//				if(!visited[nx][ny] || count[nx][ny]> count[cur.x][cur.y]+map[nx][ny]) {
//					visited[nx][ny] = true;
//					count[nx][ny] = count[cur.x][cur.y]+map[nx][ny];
//					q.offer(new point(nx, ny));
//				}
//			}
//		}
//	}
//
//
//}