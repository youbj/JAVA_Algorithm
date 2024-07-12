import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        long[] dp = new long[1001];
        dp[0] = 1;
        dp[1] = 1;

        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%MOD;
        }
        long answer = dp[n];
        System.out.println(answer);

    }
}