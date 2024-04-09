import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		Meeting[] meeting = new Meeting[tc];
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meeting[i] = new Meeting(start, end);
		}

		Arrays.sort(meeting);

		PriorityQueue<Integer> que = new PriorityQueue<>();
		que.offer(meeting[0].end);
		for (int i = 1; i < tc; i++) {

			if (meeting[i].start >= que.peek()) {
				que.poll();
			}
			que.offer(meeting[i].end);
		}

		System.out.println(que.size());
	}

	public static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}