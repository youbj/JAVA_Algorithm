import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 유병주 
 * @date 01.31
 * @link https://www.acmicpc.net/problem/11660
 * @keyword_solution  
 * N*N 개의 수를 담는 arr가 있을 때, 얼마만큼 효율적으로 합을 구하나
 * @input 
 * 누적합 형태로 값을 저장해야 하는데 저장과정에서 
 * 단순 x-1의 값과 y-1의 값을 더하면 x-1,y-1까지 중복이 발생한다
 * 그렇기 때문에 새로운 buf배열을 생성해 같은 x행의 값을 따로 저장해
 * y의 값에 더해준다
 * @output   
 * 하나의 명령에 한번의 출력
 * @time_complex  O(n)
 * @perf 128824	1732
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
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
			
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}
}