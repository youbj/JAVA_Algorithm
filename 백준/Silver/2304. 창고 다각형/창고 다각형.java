import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[1001];

		int start = 1001, end = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			heights[L] = H;

			if (L < start)
				start = L;
			if (L > end)
				end = L;
		}

		int maxPos = start, max = 0;
		for (int i = start; i <= end; i++) {
			if (heights[i] > max) {
				max = heights[i];
				maxPos = i;
			}
		}

		int area = 0;
		int now = 0;
		for (int i = start; i < maxPos; i++) {
			if (heights[i] > now) {
				now = heights[i];
			}
			area += now;
		}

		now = 0;
		for (int i = end; i > maxPos; i--) {
			if (heights[i] > now) {
				now = heights[i];
			}
			area += now;
		}

		area += max;

		System.out.println(area);
	}
}