import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int[][] dp;
    private static int n;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                max = Math.max(max, dfs(r, c));
            }
        }

        System.out.println(max);
    }

    private static int dfs(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 1; 

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && map[nr][nc] > map[r][c]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }

        return dp[r][c];
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}