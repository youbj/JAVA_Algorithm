import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int cityNum;
	static int min = Integer.MAX_VALUE;
	
	static int [][] load;
	static int []path;
	static boolean [] visited;
	
	public static void main(String[] args) throws Exception {
		cityNum = Integer.parseInt(br.readLine());
		
		load = new int[cityNum+1][cityNum+1];
		path = new int[cityNum+1];
		visited = new boolean [cityNum+1];
		
		for(int r=1; r<=cityNum; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=cityNum; c++) {
				load[r][c] =Integer.parseInt(st.nextToken());
			}
		}
		makePath(0, 0);
		
		System.out.println(min);
	}
	
	private static void makePath(int cnt, int idx) {
		if(cnt == cityNum) {
			path[cityNum] = path[0];
			howmanycost();
			return;
		}	
		
		for(int i=1;i<=cityNum;i++) {
			if(visited[i]==true) continue;
			if(idx==i) continue;
			
			visited[i] = true;
			path[cnt] = i;
			makePath(cnt+1, i);
			visited[i] = false;
		}
	}
	
	private static void howmanycost() {
		int sum=0;
		
		for(int i=0;i<cityNum;i++) {
			int from = path[i];
			int to = path[i+1];
			
			if(load[from][to]==0) return;
			
			sum+=load[from][to];
		}
		min = Math.min(min, sum);
	}
}