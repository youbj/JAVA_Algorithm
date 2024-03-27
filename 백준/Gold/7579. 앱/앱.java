import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n, m;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n];
        int[] cost = new int[n];
        int totalCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }

        int[] dp = new int[totalCost + 1];
        Arrays.fill(dp, -1); // 초기화
        dp[0] = 0; // 비용 0일 때 메모리는 0

        for (int i = 0; i < n; i++) {
            for (int j = totalCost; j >= cost[i]; j--) {
                if (dp[j - cost[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
                }
            }
        }

        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }

}