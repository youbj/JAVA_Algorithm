import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int n;
	public static int[] scv;

	public static int[][] mutalisk = { { 1, 3, 9 }, { 1, 9, 3 }, { 3, 1, 9 }, { 3, 9, 1 }, { 9, 1, 3 }, { 9, 3, 1 } };

	public static void main(String[] args) throws Exception {

		n = Integer.parseInt(br.readLine());
		scv = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		int answer = execute();
		System.out.println(answer);

	}

	public static int execute() {
		PriorityQueue<SCV> scvs = new PriorityQueue<SCV>();
		scvs.offer(new SCV(scv[0], scv[1], scv[2], 0));
		boolean[][][] visited = new boolean[61][61][61];

		while (!scvs.isEmpty()) {
			SCV now = scvs.poll();

			if (isEnd(now))
				return now.count;

			if (visited[now.a][now.b][now.c]) {
				continue;
			}

			visited[now.a][now.b][now.c] = true;

			for (int[] mutal : mutalisk) {
				int remainA = Math.max(now.a - mutal[0], 0);
				int remainB = Math.max(now.b - mutal[1], 0);
				int remainC = Math.max(now.c - mutal[2], 0);

				scvs.offer(new SCV(remainA, remainB, remainC, now.count + 1));
			}
		}
		
		return -1;
	}
	
	public static boolean isEnd(SCV o) {
		return o.a <= 0 && o.b <= 0 && o.c <= 0;
	}

	public static class SCV implements Comparable<SCV> {
		int a, b, c;
		int count;

		public SCV(int a, int b, int c, int count) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.count = count;
		}

		@Override
		public int compareTo(SCV o) {
			return Integer.compare(this.count, o.count);
		}
	}
}