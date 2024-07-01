import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static char map[][];
	public static int row, col, crush;

	public static int dr[] = { -1, 1, 0, 0 };
	public static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		crush = Integer.parseInt(st.nextToken());

		map = new char[row][col];

		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Point start = new Point(0, 0, crush, 1);
		int answer = bfs(start);
		System.out.println(answer);
	}

	public static int bfs(Point start) {
		boolean[][][] visited = new boolean[row][col][crush + 1];
		PriorityQueue<Point> que = new PriorityQueue<Point>();

		que.offer(start);
		visited[0][0][crush] = true;

		while (!que.isEmpty()) {
			Point now = que.poll();

			if (now.r == row - 1 && now.c == col - 1) {
				return now.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;

				if (isNot(nr, nc))
					continue;

				if (map[nr][nc] == '1') {
					if (now.crush > 0 && !visited[nr][nc][now.crush - 1]) {
						visited[nr][nc][now.crush - 1] = true;
						que.offer(new Point(nr, nc, now.crush - 1, now.cnt + 1));
					} else {
						continue;
					}
				} else if (map[nr][nc] == '0' && !visited[nr][nc][now.crush]) {
					visited[nr][nc][now.crush] = true;
					que.offer(new Point(nr, nc, now.crush, now.cnt + 1));
				}
			}
		}
		return -1;
	}

	public static boolean isNot(int r, int c) {
		return r < 0 || c < 0 || r >= row || c >= col;
	}

	public static class Point implements Comparable<Point> {
		int r;
		int c;
		int crush;
		int cnt;

		public Point(int r, int c, int crush, int cnt) {
			this.r = r;
			this.c = c;
			this.crush = crush;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
}