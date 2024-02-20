import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int [] flag;
	static ArrayList<Integer>[] students;
	
	static int num;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		students = new ArrayList[num+1];
		flag = new int[num+1];
		for(int i=1;i<num+1;i++) {
			students[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			flag[next]++;
			students[first].add(next);
		}
		LiningUp();
		System.out.println(sb.toString());
	}
	
	public static void LiningUp() {
		Queue<Integer>que = new ArrayDeque<Integer>();
		boolean [] selected = new boolean [num+1];
		for(int i=1;i<=num;i++) {
			if(flag[i]==0) {
				que.offer(i);
				selected[i]= true;
			}
		}
		
		while(!que.isEmpty()) {
			int current = que.poll();
			sb.append(current).append(" ");
			
			for(int next:students[current]) {
				flag[next]--;
				
				if(flag[next]==0)
					que.offer(next);
			}
		}
	}

}