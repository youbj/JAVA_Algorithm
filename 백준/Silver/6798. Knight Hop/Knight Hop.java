import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int dr[] = { -1, -2, -2, -1, 1, 2,  2,  1 };
	public static int dc[] = { -2, -1,  1,  2, 2, 1, -1, -2 };

	public static Point now, end;

	public static void main(String[] args) throws Exception {
		int r, c;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		now = new Point(r, c, 0);

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		end = new Point(r, c, 0);
		int answer = bfs();
		System.out.println(answer);
	}

	public static int bfs() {
		boolean[][] map = new boolean[9][9];
		PriorityQueue<Point> que = new PriorityQueue<Point>();
		que.offer(now);
		map[now.r][now.c] = true;

		while (!que.isEmpty()) {
			Point current = que.poll();
			if (current.r == end.r && current.c == end.c) {
				return current.cnt;
			}

			for (int i = 0; i < 8; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];

				if (isIn(nr, nc)) {
					if (map[nr][nc])
						continue;

					que.offer(new Point(nr, nc, current.cnt + 1));
					map[nr][nc] = true;
				}
			}
		}

		return -1;
	}

	public static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r < 9 && c < 9;
	}

	public static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}
}