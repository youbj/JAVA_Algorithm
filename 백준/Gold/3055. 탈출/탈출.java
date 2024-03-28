import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static int row, col;
	public static char[][] map;
	public static boolean[][] visited;
	public static Point end;
	public static Queue<Point> water = new ArrayDeque<>();
	public static Queue<Point> hog = new ArrayDeque<>();

	public static boolean flag = false;

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new char[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				
				if (map[i][j] == 'S') {
					hog.add(new Point(i, j));
					visited[i][j] = true;
				} else if (map[i][j] == 'D') {
					end = new Point(i, j);
				} else if (map[i][j] == '*') {
					water.offer(new Point(i, j));
					visited[i][j] = true;
				} else if (map[i][j] == 'X') {
					visited[i][j] = true;
				}
			}
		}
		int count = 1;
		
		while(!hog.isEmpty()) {
			waterflow();
			movieHog();
			if(flag) break;
			count++;
		}
		if(flag) {
			System.out.println(count);
		}
		else {
			System.out.println("KAKTUS");
		}
	}

	public static void movieHog() {
		int size = hog.size();
		for (int num = 0; num <size; num++) {
			Point now = hog.poll();

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;

				if (isIn(nr, nc) || visited[nr][nc])
					continue;

				if (map[nr][nc] == 'D') {
					flag = true;
					return;
				}

				visited[nr][nc] = true;
				map[nr][nc] = 'S';
				hog.offer(new Point(nr, nc));
			}
			map[now.r][now.c]= '.';
		}
	}

	public static void waterflow() {
		int size = water.size();
		for (int num = 0; num < size; num++) {
			Point now = water.poll();

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;

				if (isIn(nr, nc) || map[nr][nc] == 'D')
					continue;
				if (visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				map[nr][nc] = '*';
				water.offer(new Point(nr, nc));
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r < 0 || c < 0 || r >= row || c >= col || map[r][c] == 'X';
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}