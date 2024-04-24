import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	static int n, s, m;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(isOk(a,b,c)) {
				cnt++;
				sb.append(a+" "+b+" "+c+" ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	public static boolean isOk(int a, int b, int c) {
		return a >= m && b >= m && c >= m & a + b + c >= s;
	}

}