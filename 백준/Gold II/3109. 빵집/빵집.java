import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int r,c;
	static char[][] map;
	static int answer=0;
	static int []dx= {-1,0,1};
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i=0;i<r;i++) {
			map[i]= br.readLine().toCharArray();
		}
		
		for(int i=0;i<r;i++) {
			dfs(0,i);
		}
		System.out.println(answer);
	}
	
	static boolean dfs(int x, int y) {
		
		for(int i=0; i<3; i++) {
			int nx = x + 1;
			int ny = y + dx[i];
			
			if(nx<0 || nx>c-1 || ny<0 || ny>r-1) continue;
			if(map[ny][nx] =='.') {
				if(nx == c-1) {
					answer ++;
					return true;
				}
				
				map[ny][nx] = '-';
  			   if(dfs(nx,ny)) return true;
			}
			
		}
		return false;	
	}
	
	public static boolean isOK(int x, int y) {
		return x<0 || x>r-1 || y<0 || y>r-1;
	}
}