import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int row, col;
    public static char[][] map;
    public static boolean[][] visited;

    public static int[] dr = { -1, 1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            map[r] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int startR, int startC) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startR, startC, 1));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            int cnt = now.cnt;

            if (r == row - 1 && c == col - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isOk(nr, nc) && map[nr][nc] == '1' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc, cnt + 1));
                }
            }
        }

        return -1; 
    }

    public static boolean isOk(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }

    public static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}