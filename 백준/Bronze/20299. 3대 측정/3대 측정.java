import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	private static int n, k, l;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (isOk(a, b, c)) {
				cnt++;
				sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	public static boolean isOk(int a, int b, int c) {
		return a >= l && b >= l && c >= l && (a + b + c) >= k;
	}

}