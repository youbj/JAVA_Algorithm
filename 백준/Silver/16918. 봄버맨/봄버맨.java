import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int row;
	static int col;
	static int time;
	
	static char[][] map;
	static int[][] bombmap;
	
	static int[]dx = {0,-1,1,0,0};
	static int[]dy = {0,0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		
		row= Integer.parseInt(st.nextToken());
		col= Integer.parseInt(st.nextToken());
		time= Integer.parseInt(st.nextToken());
		
		map = new char [row][col];
		bombmap = new int [row][col];
		
		for(int r=0;r<row;r++) {
			map[r]= br.readLine().toCharArray(); 
			for(int c=0;c<col;c++) {
				if(map[r][c]=='O')
					bombmap[r][c] = 2;
			}
		}
		for(int i=1;i<time;i++) {
			ChangeMap(i, new boolean[row][col]);			
			
		}
		
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(bombmap[r][c]%4==0) {
					sb.append('.');
				}
				else {
					sb.append('O');
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());		
	}
	
	public static void ChangeMap(int cnt, boolean[][] isvisited) {
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(isvisited[r][c]) continue;			
				if(bombmap[r][c]!=0) {
					bombmap[r][c]++;
					countMap(r, c, bombmap[r][c], isvisited);
				}
			}
		}

		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {		
				if(bombmap[r][c]==0) {
					bombmap[r][c]++;
				}else if(bombmap[r][c]==4) {
					bombmap[r][c]=0;
				}
			}
		}
	}
	
	public static void countMap(int r, int c, int cnt, boolean[][] isvisited) {

		for(int i=0;i<5;i++) {
			int nx= c+dx[i];
			int ny= r+dy[i];
			
			if(nx<0 || nx>=col ||ny<0 || ny>=row ) continue;
			
			if(bombmap[ny][nx]!=0) continue;
			
			isvisited[ny][nx]=true;
		
			bombmap[ny][nx]=cnt;

		}
	}
}