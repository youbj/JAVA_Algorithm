import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    public static boolean[][] visited;

    public static int row, col;

    public static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }


        }


        int answer = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    bfs(r, c);
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nowR = now[0];
            int nowC = now[1];
            for (int i = 0; i < 8; i++) {
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];
                if (isOk(nr, nc)) {
                    continue;
                }
                que.offer(new int[]{nr, nc});
                visited[nr][nc] = true;

            }
        }
    }

    public static boolean isOk(int r, int c) {
        return r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || map[r][c] == 0;
    }

}