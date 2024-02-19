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
	
	static ArrayList<Integer>[] friends;
	static int n;
	static int m;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		friends = new ArrayList [n+1];
		for(int i=1;i<n+1;i++) {
			friends[i]= new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			
			int fr1= Integer.parseInt(st.nextToken());
			int fr2= Integer.parseInt(st.nextToken());
			
			friends[fr1].add(fr2);
			friends[fr2].add(fr1);
		}
		int answer=-1;
		
		for(int idx=1;idx<=n;idx++) {
			int result = bfs(idx);
			if(result<min) {
				answer=idx;
				min=result;
			}
		}
		System.out.println(answer);
	}
	
	static int bfs(int start){
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(start);
		boolean [] selected = new boolean [n+1];
		int [] cntbacon = new int [n+1];
		
		while(!que.isEmpty()) {
			int current = que.poll();
			
			for(int friend:friends[current]) {
				if(selected[friend]) continue;
				
				que.offer(friend);
				selected[friend]=true;
				cntbacon[friend]=cntbacon[current]+1;
			}
		}
		
		int sum =0;
		for(int i=1;i<=n;i++) {
			sum+=cntbacon[i];
		}
		return sum;
	}
}