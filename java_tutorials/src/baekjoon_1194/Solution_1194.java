//package baekjoon_1194;
//
//import java.util.*;
//import java.io.*;
//
//public class Solution_1194 {
//
//	static int[] alpha_key= {0,0,0,0,0,0};
//	static class Point {
//		int x,y,count;
//		Point(int x, int y,int count){
//			this.x=x;
//			this.y=y;
//			this.count=count;
//		}
//	}
//	
//	public static void main(String[]args) throws IOException {		
//		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		st=new StringTokenizer(br.readLine());
//		int n,m;
//		
//		n=Integer.parseInt(st.nextToken());
//		m=Integer.parseInt(st.nextToken());
//		
//		char [][] map= new char[m][n];
//		Point start_point = null;
//		
//		for(int i=0;i<m;i++) {
//			String str=br.readLine();
//			
//			for(int j=0;j<n;j++) {
//				map[i][j]=str.charAt(j);
//				if(map[i][j]=='0') {
//					start_point= new Point(i,j,0);
//				}
//			}
//		}
//		
//		bfs(start_point,map);
//	}
//	
//	public static void map_key(char c){			
//		if(c>='a'&&c<='f') {
//			alpha_key[c-'a']++;
//		}
//		else if(c>='A'||c<='F'){
//			if(alpha_key[c-'A']==0) {
//				
//			}
//			else alpha_key[c-'A']--;
//		}		
//	}
//	
//	public static void bfs(Point start_point, char[][]map) {
//		Queue<Point> que = new LinkedList<>();
//		int []dx= {1,-1,0,0};
//		int []dy= {0,0,1,-1};
//		
//		que.offer(start_point);
//		
//	}
//}