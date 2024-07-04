import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int size;
    public static int[][] map;
    public static long[][] dp;

    public static void main(String[] args) throws Exception {
        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        dp = new long[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dp[i][j] == 0 || (i == size - 1 && j == size - 1)) continue;
                int jump = map[i][j];
                if (i + jump < size) {
                    dp[i + jump][j] += dp[i][j];
                }
                if (j + jump < size) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }
        System.out.println(dp[size - 1][size - 1]);
    }
}