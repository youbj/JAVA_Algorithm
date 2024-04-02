import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BigInteger [] dp;
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		
		dp = new BigInteger[n+2];
		dp[0]=new BigInteger("0");
		dp[1]=new BigInteger("1");
		if(n<=1) {
			System.out.println(n);
			return;
		}
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-2].add(dp[i-1]);
		}
		System.out.println(dp[n]);
	}
}