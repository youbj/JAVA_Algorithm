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

        map = new char[row][col];
        for (int r = 0; r < row; r++) {
            map[r] = br.readLine().toCharArray();
        }

        String answer = bfs();
        System.out.print(answer);
    }

    public static String bfs() {
        Queue<Point> que = new ArrayDeque<>();
        boolean[][][][] isVisited = new boolean[row][col][k + 1][k + 1];
        que.offer(new Point(0, 0, k, k));
        isVisited[0][0][k][k] = true;

        while (!que.isEmpty()) {
            Point now = que.poll();

            if (now.r == row - 1 && now.c == col - 1) {
                return "Yes";
            }

            char dir = map[now.r][now.c];
            int stdDir = getDirection(dir);

            for (int i = -3; i <= 3; i++) {
                int newDir = (stdDir + i + 4) % 4;  
                int nr = now.r + dr[newDir];
                int nc = now.c + dc[newDir];
                int nLeft = now.left + (i < 0 ? i : 0);
                int nRight = now.right - (i > 0 ? i : 0);

                if (nLeft < 0 || nRight < 0 || cantGo(nr, nc)) continue;

                if (!isVisited[nr][nc][nLeft][nRight]) {
                    isVisited[nr][nc][nLeft][nRight] = true;
                    que.offer(new Point(nr, nc, nLeft, nRight));
                }
            }
        }
        return "No";
    }

    public static boolean cantGo(int r, int c) {
        return r < 0 || c < 0 || r >= row || c >= col;
    }

    public static int getDirection(char dir) {
        switch (dir) {
            case 'U': return 0;
            case 'R': return 1;
            case 'D': return 2;
            case 'L': return 3;
            default: throw new IllegalArgumentException("Invalid direction: " + dir);
        }
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