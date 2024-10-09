import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author	유병주 
 * @date 	02.16
 * @link	https://www.acmicpc.net/problem/1987
 * @keyword_solution
 * bfs? dfs?
 * 1. bfs
 *  - bfs의 경우 경로마다 boolean값이 다르기 때문에 사용할 수 없음
 * 2. dfs
 *  - 알파벳이 26글자에 최대 20*20의 크기를 가지는 배열에 존재하므로 
 *    dfs를 사용하는 것도 좋을 것이라고 생각됨  
 * @input 
 *  - char 이중 배열로 입력받으면 될 듯
 * @output
 *  - 최대값을 계속 비교해주면서 해주면 될 듯
 * @time_complex
 *  - O(4*n^2)
 * @perf 
 * 291680	1088
 */

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static char [][] alphabets;
	static boolean [] isSelected=new boolean[26];
	static int row;
	static int col;
	
	static int[]dx = {-1,1,0,0};
	static int[]dy = {0,0,-1,1};
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		row= Integer.parseInt(st.nextToken());
		col= Integer.parseInt(st.nextToken());
		
		alphabets = new char[row][col];
		
		for(int i=0;i<row;i++) {
			alphabets[i]= br.readLine().toCharArray();
		}
		isSelected[alphabets[0][0]-'A']=true;
		dfs(0,0,1);
		System.out.println(max);
	}
	
	public static void dfs(int x,int y,int cnt) {
		//실행
		for(int i=0;i<4;i++) {
			int ny= y+dy[i];
			int nx= x+dx[i];
			
			if(isVailid(nx, ny))
				continue;			
			char nextAlpha = alphabets[ny][nx];	
			if (!isSelected[nextAlpha - 'A']) {
				isSelected[nextAlpha - 'A'] = true;
				dfs(nx,ny, cnt + 1);
				
				isSelected[nextAlpha - 'A'] = false;
			}		
		}
		max= Math.max(max, cnt);
	}
	
	public static boolean isVailid(int x,int y) {
		return x<0 || x>=col || y<0 || y>=row ;
	}
}