import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int n;
	private static List<Ramen> ramens;
	
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());

		ramens = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int cupramen = Integer.parseInt(st.nextToken());
			ramens.add(new Ramen(deadline,cupramen));
		}
		Collections.sort(ramens);
		
		long answer=execute();		
		
		System.out.println(answer);
	}
	
	public static long execute() {
		long result =0;
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		for(Ramen ramen:ramens) {
			que.offer(ramen.num);
			if(que.size() > ramen.dl) {
				que.poll();
			}
		}
		
		for(int cr:que) {
			result+=cr;
		}
		
		return result;
	}
	
	
	public static class Ramen implements Comparable<Ramen>{
		int dl;
		int num;
		public Ramen(int dl, int num) {
			super();
			this.dl = dl;
			this.num = num;
		}
		
		@Override
		public int compareTo(Ramen o) {
			if(this.dl==o.dl) {
				return Integer.compare(o.num, this.num);
			}
			return Integer.compare(this.dl, o.dl);
		}		
	}
}