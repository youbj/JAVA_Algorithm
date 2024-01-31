import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[]arr;
	static int[] exps;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n=Integer.parseInt(br.readLine());
		arr=new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		exps= new int[4]; 
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			exps[i]=Integer.parseInt(st.nextToken());
		}
		
		makeEXP(1,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void makeEXP(int cnt, int inter_result) {
		if(cnt==n) {
			max=Math.max(max, inter_result);
			min=Math.min(min, inter_result);
			return ;
		}
		for(int i=0;i<4;i++) {
			if(exps[i]==0)
				continue;
			exps[i]--;
			switch(i) {
			case 0:
				makeEXP(cnt+1,inter_result+arr[cnt]);
				break;
			case 1:
				makeEXP(cnt+1,inter_result-arr[cnt]);
				break;
			case 2:
				makeEXP(cnt+1,inter_result*arr[cnt]);
				break;
			case 3:
				makeEXP(cnt+1,inter_result/arr[cnt]);
				break;
			}
			exps[i]++;
		}
	}
}