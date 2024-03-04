import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Time[] times;
	public static void main(String[] args) throws Exception{		
		int n = Integer.parseInt(br.readLine());
		times = new Time[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			times[i] = new Time(start, end);
		}
		makesubject();
		
	}
	public static void makesubject() {
		Arrays.sort(times);
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		que.offer(times[0].end);
		int cnt=1;
		
		for(int i=1; i<times.length;i++) {
			if(times[i].start < que.peek())
				que.offer(times[i].end);
			else {
				que.poll();
				que.offer(times[i].end);
			}
		}
		System.out.println(que.size());
		return;
	}
	
	public static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
			return Integer.compare(this.start,o.start);
		}
	}

}