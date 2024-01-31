import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
 * 페어의 도움으로 해결 
 * @output   
 * 하나의 명령에 한번의 출력
 * @time_complex  O(n)
 * @perf 
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int []arr;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		arr=new int[n+1];
		st=new StringTokenizer(br.readLine());
		arr[0]=0;
		arr[1]=Integer.parseInt(st.nextToken());
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(arr[end]-arr[start-1]);
		}
		
	}
	
	private static int calc_sum(int start,int end) {
		int sum=0;
		for(int i=start;i<end;i++)
			sum+=arr[i];
		return sum;
	}
}