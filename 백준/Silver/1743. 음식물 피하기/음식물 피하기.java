import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    public static boolean[][] visited;
    public static int row, col;

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static int max = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1;
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    exec(r, c);
                }
            }
        }
        System.out.println(max);
    }

    public static void exec(int r, int c) {
        Queue<int[]> que = new ArrayDeque<int[]>();
        que.offer(new int[]{r, c});
        visited[r][c] = true;
        int answer = 0;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            answer++;
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (check(nr, nc) || map[nr][nc] == 0 || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                que.offer(new int[]{nr, nc});
            }
        }
        max = Math.max(max, answer);
    }

    public static boolean check(int r, int c) {
        return r < 0 || c < 0 || r >= row || c >= col;
    }
}