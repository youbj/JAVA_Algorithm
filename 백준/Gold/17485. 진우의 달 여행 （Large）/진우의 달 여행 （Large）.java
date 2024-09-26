import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int row, col;
    public static int[][] space;

    public static int[] dr = {1, 1, 1};
    public static int[] dc = {-1, 0, 1};

    public static final int INF = 100000000;

    public static void main(String[] args) throws Exception {
        init();
        int answer = exec();
        System.out.println(answer);
    }

    public static int exec() {
        int[][][] dp = new int[row][col][3];

        for (int c = 0; c < col; c++) {
            for (int d = 0; d < 3; d++) {
                dp[0][c][d] = space[0][c];
            }
        }

        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int d = 0; d < 3; d++) {
                    int prevC = c - dc[d];

                    if (prevC < 0 || prevC >= col) {
                        dp[r][c][d] = INF;
                        continue;
                    }

                    int minPrev = INF;
                    for (int pd = 0; pd < 3; pd++) {
                        if (pd != d) {
                            minPrev = Math.min(minPrev, dp[r-1][prevC][pd]);
                        }
                    }
                    dp[r][c][d] = space[r][c] + minPrev;
                }
            }
        }

        int minCost = INF;
        for (int c = 0; c < col; c++) {
            for (int d = 0; d < 3; d++) {
                minCost = Math.min(minCost, dp[row-1][c][d]);
            }
        }

        return minCost;
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        space = new int[row][col];

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                space[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
}