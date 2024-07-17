import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int row, col, height;
    public static int[][][] map;
    public static boolean[][][] visited;

    public static int max = 0;

    public static ArrayList<Point> tomato = new ArrayList<Point>();

    public static int dr[] = {-1, 1, 0, 0, 0, 0};
    public static int dc[] = {0, 0, -1, 1, 0, 0};
    public static int dh[] = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        map = new int[row][col][height];
        visited = new boolean[row][col][height];

        for (int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < col; c++) {
                    map[r][c][h] = Integer.parseInt(st.nextToken());
                    if (map[r][c][h] == 1) {
                        tomato.add(new Point(r, c, h, 0));
                        visited[r][c][h] = true;
                    }
                }
            }
        }


        bfs();
        for (int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (map[r][c][h] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs() {
        Queue<Point> que = new ArrayDeque<Point>();

        for (int i = 0; i < tomato.size(); i++) {
            que.offer(tomato.get(i));
        }

        while (!que.isEmpty()) {
            Point now = que.poll();
            boolean flag = true;

            for (int i = 0; i < 6; i++) {
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;
                int nh = dh[i] + now.h;

                if (isOk(nr, nc, nh) || visited[nr][nc][nh] || map[nr][nc][nh] != 0) {
                    continue;
                }

                map[nr][nc][nh] = 1;
                visited[nr][nc][nh] = true;
                que.offer(new Point(nr, nc, nh, now.cnt + 1));
                flag = false;
            }

            if (flag) {
                max = Math.max(max, now.cnt);
            }
        }
    }


    public static boolean isOk(int r, int c, int h) {
        return r < 0 || r >= row || c < 0 || c >= col || h < 0 || h >= height;
    }

    public static class Point {
        int r, c, h;
        int cnt;

        public Point(int r, int c, int h, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.h = h;
            this.cnt = cnt;
        }
    }
}