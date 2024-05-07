import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static int col, row;
	private static int[][] map;
	private static int[][] visited;
	private static Map<Integer, Integer> roomSizeMap = new HashMap<>();

	private static int maxRoom = 0;
	private static int maxSumRoom = 0;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		visited = new int[row][col];

		for (int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < col; c++) {
				int bit = Integer.parseInt(st.nextToken());
				map[r][c] = bit;
			}
		}
		int roomNum = countRoom();
		System.out.println(roomNum);
		System.out.println(maxRoom);
		System.out.println(maxSumRoom);
	}

	public static int countRoom() {
		int count = 0;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (visited[r][c] == 0) {
					count++;
					int roomsize = countRoomSize(r, c, count);
					maxRoom = Math.max(maxRoom, roomsize);
					roomSizeMap.put(count, roomsize);
				}
			}
		}

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int roomNum = map[r][c];

				for (int i = 0; i < 4; i++) {
					if ((roomNum & (1 << i)) > 0) {
						int nc = c + dc[i];
						int nr = r + dr[i];
						if (nr < 0 || nc < 0 || nr >= row || nc >= col)
							continue;
						if (visited[nr][nc] != visited[r][c]) {
							int combinedSize = roomSizeMap.get(visited[r][c]) + roomSizeMap.get(visited[nr][nc]);
							maxSumRoom = Math.max(maxSumRoom, combinedSize);
						}

					}
				}
			}
		}

		return count;
	}

	public static int countRoomSize(int r, int c, int num) {
		Queue<Point> que = new ArrayDeque<Point>();
		que.offer(new Point(r, c));
		visited[r][c] = num;
		int count = 0;

		while (!que.isEmpty()) {
			Point now = que.poll();
			count++;

			int wall = map[now.r][now.c];

			for (int i = 0; i < 4; i++) {
				if ((wall & (1 << i)) == 0) {
					int nc = now.c + dc[i];
					int nr = now.r + dr[i];
					
					if (visited[nr][nc] == 0) {
						que.offer(new Point(nr, nc));
						visited[nr][nc] = num;
					}
				}
			}
		}
		return count;
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}