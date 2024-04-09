import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		Count [] cnt = new Count[41]; 
		cnt[0] = new Count(1,0);
		cnt[1] = new Count(0,1);
		
		for(int i=2;i<=40;i++) {
			int zero = cnt[i-1].zero+cnt[i-2].zero;
			int one = cnt[i-1].one+cnt[i-2].one;
			cnt[i] = new Count(zero,one); 
		}
		
		int test = Integer.parseInt(br.readLine());
		for(int i=0;i<test;i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(cnt[num].zero).append(" ").append(cnt[num].one).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static class Count{
		int zero;
		int one;
		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
		
	}
}