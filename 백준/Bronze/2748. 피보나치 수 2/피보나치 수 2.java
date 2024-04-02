import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static long [] dp;
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		
		dp = new long[n+2];
		dp[0]=0;
		dp[1]=1;
		if(n<=1) {
			System.out.println(n);
			return;
		}
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		System.out.println(dp[n]);
	}
}