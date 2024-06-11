import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int n;

	public static Task[] tasks;

	public static void main(String[] args) throws Exception {

		n = Integer.parseInt(br.readLine());
		tasks = new Task[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int date = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			tasks[i] = new Task(date, score);
		}

		Arrays.sort(tasks);
		int maxDate = 0;

		for (Task task : tasks) {
			maxDate = Math.max(task.date, maxDate);
		}

		boolean[] scheduled = new boolean[maxDate + 1];
		int totalScore = 0;

		for (Task task : tasks) {
			for (int d = task.date; d > 0; d--) {
				if (!scheduled[d]) {
					scheduled[d] = true;
					totalScore += task.score;
					break;
				}
			}
		}

		System.out.println(totalScore);
	}

	public static class Task implements Comparable<Task> {
		int date;
		int score;

		public Task(int date, int score) {
			this.date = date;
			this.score = score;
		}

		@Override
		public int compareTo(Task o) {
			if (o.score == this.score) {
				return Integer.compare(this.date, o.date);
			}

			return Integer.compare(o.score, this.score);
		}
	}
}