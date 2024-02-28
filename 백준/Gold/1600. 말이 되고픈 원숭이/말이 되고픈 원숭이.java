import java.io.*;
import java.util.*;

class Point {
	public int y, x;
	public int horseCount;		// 현재 지점까지 말처럼 동작한 횟수
	public int totalCount;		// 현재 지점까지 전체 동작 횟수 (말 + 원숭이)

	public Point(int y, int x, int horseCount, int totalCount) {
		this.x = x;
		this.y = y;
		this.horseCount = horseCount;
		this.totalCount = totalCount;
	}
}

public class Main {
	static int k;		// 원숭이가 말 처럼 동작 가능한 최대 횟수
	static int h, w;	// h x w 행렬
	static int[][] map;
	static int minCount = Integer.MAX_VALUE;	// 원숭이의 최소 동작 횟수

	static Queue<Point> queue = new LinkedList<>();
	// check[y][x][k]: [y, x] 위치를 말 처럼 k 번 동작하여 방문 여부 확인
	static boolean[][][] check;
	static int[] dy = { -1, 1, 0, 0 };	// 원숭이 이동: 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] hdy = { -2, -2, -1, -1, +1, +1, +2, +2 };	// 말 이동
	static int[] hdx = { -1, +1, -2, +2, -2, +2, -1, +1 };

	static void bfs() {
		while (!queue.isEmpty()) {
			Point current = queue.remove();
			int horseCount = current.horseCount;
			int totalCount = current.totalCount;

			if (current.y == h - 1 && current.x == w - 1) {
				minCount = current.totalCount;
				return;
			}

			// 원숭이로 이동하는 경우
			for (int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if (ny < 0 || ny >= h || nx < 0 || nx >= w)	// 다음 지점이 범위 밖인 경우
					continue;

				// 인접한 지점이 평지이고, 아직 방문 안한 경우
				if (map[ny][nx] == 0 && !check[ny][nx][horseCount]) {
					check[ny][nx][horseCount] = true;
					queue.add(new Point(
							ny, nx, horseCount, totalCount + 1
					));
				}
			}

			// 말 처럼 동작하여 이동하는 경우
			if (horseCount < k) {
				for (int i = 0; i < 8; i++) {
					int hy = current.y + hdy[i];
					int hx = current.x + hdx[i];

					if (hy < 0 || hy >= h || hx < 0 || hx >= w)	// 다음 지점이 범위 밖인 경우
						continue;

					// 인접한 지점이 평지이고, 아직 방문 안한 경우
					if (map[hy][hx] == 0 && !check[hy][hx][horseCount + 1]) {
						check[hy][hx][horseCount + 1] = true;
						queue.add(new Point(
								hy, hx, horseCount + 1, totalCount + 1
						));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		// check[][][0] ~ [][][k] 사용: 말 처럼 동작 횟수 0번 ~ k 번까지
		check = new boolean[h][w][k + 1];
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		check[0][0][0] = true;
		queue.add(new Point(0, 0, 0, 0));
		bfs();

		if (minCount != Integer.MAX_VALUE)
			System.out.println(minCount);
		else
			System.out.println(-1);
	}
}