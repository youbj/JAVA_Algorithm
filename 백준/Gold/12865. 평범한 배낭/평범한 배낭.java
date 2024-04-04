import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, k;
	static int[][] product;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		product = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			product[i][0] = Integer.parseInt(st.nextToken());
			product[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] bag = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= product[i][0]; j--) {
				bag[j] = Math.max(bag[j], bag[j - product[i][0]] + product[i][1]);
			}
		}
		System.out.println(bag[k]);
	}

}