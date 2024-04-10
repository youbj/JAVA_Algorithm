import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int list[][] = new int [n][n];
		list[0][0] = Integer.parseInt(br.readLine());
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(j==0) {
					list[i][j] = list[i-1][j]+num;
				} else if(j==i) {
					list[i][j] = list[i-1][j-1]+num;
				} else {
					list[i][j] = Math.max(list[i-1][j]+num, list[i-1][j-1]+num);
				}
			}
		}
		int answer =0;
		for(int num:list[n-1]) {
			answer = Math.max(num, answer);
		}
		System.out.println(answer);
	}
}