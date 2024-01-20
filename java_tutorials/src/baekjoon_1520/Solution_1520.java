package baekjoon_1520;
//
//import java.io.*;
//import java.util.*;
//
//class Point{
//	int x,y,dist;
//	Point(int x, int y){
//		this.x=x;
//		this.y=y;
//	}
//}
//
//public class Solution_1520 {
//	
//	static int n,m;
//	static int count=0;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		st=new StringTokenizer(br.readLine());
//		
//		n=Integer.parseInt(st.nextToken());
//		m=Integer.parseInt(st.nextToken());
//		boolean [][]is_visited=new boolean[n][m];
//		int [][]map = new int [n][m];
//		
//		for(int i=0;i<n;i++) {
//			st= new StringTokenizer(br.readLine());
//			for(int j=0;j<m;j++) {
//				map[i][j]=Integer.parseInt(st.nextToken());
//			}
//		
//		}
//		Point start=new Point(0,0);
//		bfs(start,map,is_visited);
//		System.out.println(count);
//	}
//	
//	public static void bfs(Point start,int[][]map, boolean [][]is_visited) {
//		Queue<Point> que = new LinkedList<>();
//		que.offer(start);
//		int[]dx= {1,0, 0};
//		int[]dy= {0, -1, 1};
//		is_visited[start.x][start.y]=true;
//		
//		while(!que.isEmpty()) {
//			Point current=que.poll();
//			
//			if(current.x==n-1&&current.y==n-1) {
//				++count;
//				continue;
//			}
//
//			for(int i=0;i<3;i++) {
//				int nx = current.x+dx[i];
//				int ny = current.y+dy[i];
//				
//				if(nx<0||nx>=n||ny<0||ny>=m)
//					continue;
//				if(map[current.x][current.y]>map[nx][ny]) {
//					
//					que.offer(new Point(nx,ny));					
//				}			
//			}		
//		}
//		
//	}
//
//}
//
//import java.io.*;
//import java.util.*;
//
//public class Solution_1520 {
//    static int n, m;
//    static int[][] map;
//    static int[][] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        map = new int[n][m];
//        dp = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//                dp[i][j] = -1;
//            }
//        }
//
//        int result = dfs(0, 0); 
//
//        System.out.println(result);
//        
//        br.close();
//    }
//
//    public static int dfs(int x, int y) {
//        int[] dx = {1, 0, 0,-1};
//        int[] dy = {0, -1, 1,0};
//        if (x == n-1 && y == m-1) {
//            return 1; 
//        }
//
//        if (dp[x][y] != -1) {
//            return dp[x][y]; 
//        }
//
//        dp[x][y] = 0; 
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            
//            if(nx<0||nx>=n||ny<0||ny>=m)
//            	continue;
//            
//            if (map[x][y] > map[nx][ny]) {
//                dp[x][y] += dfs(nx, ny); 
//            }
//        }
//
//        return dp[x][y]; 
//    }
//}

