import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static char[][] map;
    public static int row, col, k;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Point start = new Point(0, 0, k, k);

        map = new char[row][col];

        for (int r = 0; r < row; r++) {
            map[r] = br.readLine().toCharArray();
        }
        String answer = bfs(start);

        System.out.println(answer);
    }

    public static String bfs(Point start) {
        Queue<Point> que = new ArrayDeque<Point>();
        boolean[][][][] isVisited = new boolean[row][col][k + 1][k + 1];
        que.offer(start);

        while (!que.isEmpty()) {
            Point now = que.poll();

            if (cantGo(now.r, now.c))
                continue;

            if (isVisited[now.r][now.c][now.left][now.right])
                continue;
            isVisited[now.r][now.c][now.left][now.right] = true;

            char dir = map[now.r][now.c];

            if (now.r == row - 1 && now.c == col - 1) {
                return "Yes";
            }

            int nr = now.r, nc = now.c;
            int stdDir = -1;
            if (dir == 'U') {
                stdDir = 0;
            } else if (dir == 'R') {
                stdDir = 1;
            } else if (dir == 'D') {
                stdDir = 2;
            } else if (dir == 'L') {
                stdDir = 3;
            }

            nr = now.r + dr[stdDir];
            nc = now.c + dc[stdDir];
            que.offer(new Point(nr, nc, now.left, now.right));

            if (now.left > 0) {
                int leftDir = (stdDir + 3) % 4;
                nr = now.r + dr[leftDir];
                nc = now.c + dc[leftDir];
                que.offer(new Point(nr, nc, now.left - 1, now.right));
            }

            if (now.right > 0) {
                int rightDir = (stdDir + 1) % 4;
                nr = now.r + dr[rightDir];
                nc = now.c + dc[rightDir];
                que.offer(new Point(nr, nc, now.left, now.right - 1));
            }
        }
        return "No";
    }

    public static boolean cantGo(int r, int c) {
        return r < 0 || c < 0 || r >= row || c >= col;
    }

    public static class Point {
        int r, c;
        int left, right;

        public Point(int r, int c, int left, int right) {
            this.r = r;
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }
}