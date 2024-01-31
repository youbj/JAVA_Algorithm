import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 유병주 
 * @date 01.31
 * @link https://www.acmicpc.net/problem/11659
 * @keyword_solution  
 * N개의 수를 담는 arr가 있을 때, 얼마만큼 효율적으로 합을 구하나
 * @input 
 * arr의 길이 N, 명령의 수 M일 때, N과M은 100,000보다 작거나 같다.
 * arr의 요소는 1000보다 작거나 같다.
 * 즉 sum의 최대는 100,000,000 = 억 int가능

 * @output   
 * 하나의 명령에 한번의 출력
 * @time_complex  O(n)
 * @perf 59304	1460
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int [][]arr;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		arr= new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			int []buf=new int[n+1];
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				buf[j]=buf[j-1]+Integer.parseInt(st.nextToken());
				arr[i][j]=buf[j]+arr[i-1][j];
			}
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			
			int sum=arr[x2][y2];
			int sub=arr[x2][y1-1]+arr[x1-1][y2]-arr[x1-1][y1-1];
			
			sum-=sub;
			
			System.out.println(sum);
		}	
	}
}