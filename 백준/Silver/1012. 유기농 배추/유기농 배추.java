import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int row, col, cab;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dr = { -1, 1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            cab = Integer.parseInt(st.nextToken());

            map = new int[row][col];
            visited = new boolean[row][col];

            for (int i = 0; i < cab; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            int count = 0;

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        dfs(r, c);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}