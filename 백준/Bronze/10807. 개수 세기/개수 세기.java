import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int answer[] = new int[201];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			answer[num+100]++;
		}
		int ans = Integer.parseInt(br.readLine())+100;
		System.out.println(answer[ans]);
	}
}