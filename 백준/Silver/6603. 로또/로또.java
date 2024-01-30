import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int []lotto;
	static int []answer=new int[6];
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception{
		while(true) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			lotto=new int[n];
			
			for(int i=0;i<n;i++) {
				lotto[i]=Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void dfs(int start,int dep) {
		if(dep==6) {
			for(int num:answer) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<n;i++) {
			answer[dep]=lotto[i];
			dfs(i+1,dep+1);
		}
	}
}