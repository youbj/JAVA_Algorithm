import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static long [] dp;

	public static void main(String[] args) throws Exception{
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testcase;tc++) {
			int n= Integer.parseInt(br.readLine());
			dp = new long[n+3];	
			
			dp[1]=1;
			dp[2]=1;
			dp[3]=1;
			if(n<=3) {
				sb.append(dp[n]).append("\n");
				continue;
			}
			
			for(int i=4;i<=n;i++) {
				dp[i] = dp[i-2]+dp[i-3];
			}
			sb.append(dp[n]).append("\n");	
		}
		System.out.println(sb.toString());

	}

}