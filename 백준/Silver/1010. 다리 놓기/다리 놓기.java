import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 유병주
 * @date 	02.28
 * @link	https://www.acmicpc.net/problem/1010
 * @keyword_solution  
 * 조합
 * @input 
 * 오른쪽에 사이트 N개와 왼쪽에 사이트 M개가 있으며 
 * N <= M 이니까 M에서 N개를 뽑으면 될 것이다.
 * @output   
 * 
 * @time_complex  
 * max O(30*30)
 * @perf 11852	80
 */

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int arr[][] = new int [31][31];
	
	public static void main(String[] args) throws Exception{
		int testcase = Integer.parseInt(br.readLine());
		
		comb();
		
		for(int tc=1;tc<=testcase;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int left,right;
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());
			sb.append(arr[right][left]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void comb() {
		for(int i=0;i<=30;i++) {
			for(int j=0, end = Math.min(i, 30);j<=end;j++) {
				if(j==0||j==i) 
					arr[i][j] =1;
				else {
					arr[i][j] = arr[i-1][j-1]+ arr[i-1][j];
				}
			}
		}
	}
	
}