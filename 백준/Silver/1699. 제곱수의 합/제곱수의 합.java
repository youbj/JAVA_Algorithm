import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			value[i] = i;
			for (int j = 1; j * j <= i; j++) {
				value[i] = Math.min(value[i], value[i - j * j] + 1);
			}
		}
		System.out.println(value[n]);
	}
}