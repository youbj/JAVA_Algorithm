import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int row, col;
    public static int[][] map;

    public static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for (int r = 0; r < row; r++) {
            char[] buf = br.readLine().toCharArray();

            for (int c = 0; c < col; c++) {
                if (buf[c] > '0' && buf[c] <= '9')
                    map[r][c] = buf[c] - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Point> que = new ArrayDeque<>();

        for (int r =0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 0) {
                    que.offer(new Point(r, c));
                }
            }
        }

        int maxTime = -1;

        while (!que.isEmpty()) {
            maxTime++;
            int queSize = que.size();
            for (int size = 0; size < queSize; size++) {
                Point now = que.poll();
                for (int i = 0; i < 8; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (isIn(nr, nc) && map[nr][nc] > 0 && map[nr][nc] < 9) {
                        map[nr][nc]--;
                        if (map[nr][nc] == 0) {
                            que.offer(new Point(nr, nc));
                        }
                    }
                }
            }
        }

        return maxTime;
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}