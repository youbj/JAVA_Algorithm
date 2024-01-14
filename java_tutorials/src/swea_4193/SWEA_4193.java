//package swea_4193;
//
//import java.util.*;
//import java.io.FileInputStream;
//
//class Point {
//	public int x, y;
//
//	Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class SWEA_4193 {
//
//	public static void main(String args[]) throws Exception {
//
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T = sc.nextInt();
//
//		for (int test_case = 1; test_case <= T; test_case++) {
//			int n = sc.nextInt();
//			int[][] arr = new int[n][n];
//			int[][] visited = new int[n][n];
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					int a = sc.nextInt();
//					arr[i][j] = a;
//					if (a == 1)
//						visited[i][j] = 1;
//				}
//			}
//			int x, y;
//			x = sc.nextInt();
//			y = sc.nextInt();
//			Point start = new Point(x, y);
//			x = sc.nextInt();
//			y = sc.nextInt();
//			Point end = new Point(x, y);
//			
//			int result = bfs(arr, visited, start, end);
//            System.out.println("#" + test_case + " " + result);
//		}
//		sc.close();
//	}
//
//	private static int bfs(int[][] arr, int[][] visited, Point start, Point end) {
//		Queue<Point> que = new LinkedList<>();
//		que.offer(start);
//		visited[start.x][start.y]=1;
//		int dis=0;
//		int [] dx= {-1,1,0,0};
//		int [] dy= {0,0,-1,1};
//		
//		while(!que.isEmpty()) {
//			int size = que.size();
//			
//			for(int i=0;i<size;i++) {
//				Point current = que.poll();
//				
//				if(current.x==end.x&&current.y==end.y) {
//					return dis;
//				}
//				
//				for(int j=0;j<4;j++) {
//					int nx = current.x + dx[j];
//					int ny = current.y + dy[j];
//					
//					if(isValid(nx,ny,arr.length)&&visited[nx][ny]!=1) {
//						if (arr[nx][ny] == 0) {
//						    que.offer(new Point(nx, ny));
//						    visited[nx][ny] = 1;
//						} else if (arr[nx][ny] == 2 &&  dis % 3 == 2) {
//						    que.offer(new Point(nx, ny));
//						    visited[nx][ny] = 1;
//						}
//					}
//				}
//			}
//			
//			dis++;
//		}
//		
//		return -1;
//	}
//	
//	private static boolean isValid(int x, int y, int n) {
//	    return x >= 0 && x < n && y >= 0 && y < n;
//	}
//
//}
