import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int answer;
	public static Stack<Task> tasks = new Stack<Task>();

	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		answer = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if(order==0) {
				if(tasks.isEmpty())
					continue;
				Task now = tasks.pop();
				checking(now);
			}
			else {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken()) - 1;
				checking(new Task(score,time));
			}
				
		}
		System.out.println(answer);
	}
	public static void checking(Task now) {
		if(now.time==0) {
			answer+=now.score;
		}
		else {
			tasks.add(new Task(now.score,now.time-1));
		}
	}

	public static class Task {
		int score;
		int time;

		public Task(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
}