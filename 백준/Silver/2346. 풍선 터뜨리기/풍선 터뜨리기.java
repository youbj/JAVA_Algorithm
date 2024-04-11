import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Ballon> que = new ArrayDeque<Ballon>(n);
				
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int value = Integer.parseInt(st.nextToken());
			que.add(new Ballon(i,value));
		}
		
		int next = 1;
		
		while(!que.isEmpty()) {
			
			if(next>0) {
				--next;
				Ballon buf = que.pollFirst();
				if(next==0) {
					sb.append(buf.index).append(" ");
					next = buf.value;
					continue;
				}
				que.addLast(buf);
			}
			else if(next<0) {
				++next;
				Ballon buf = que.pollLast();
				if(next==0) {
					sb.append(buf.index).append(" ");
					next = buf.value;
					continue;
				}
				que.addFirst(buf);
			}
		}
		System.out.println(sb.toString());
	}
	
	public static class Ballon{
		int index;
		int value;
		
		public Ballon(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}