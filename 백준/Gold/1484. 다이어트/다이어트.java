import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int g = Integer.parseInt(br.readLine());
		boolean notFound = true;

		for (long a = 1; a * a - ((a - 1) * (a - 1)) <= g; a++) {
			long bSqr = a * a - g;

			if (bSqr > 0) {
				long b = (long) Math.sqrt(bSqr);

				if (b * b == bSqr && b < a) {
					sb.append(a).append("\n");
					notFound = false;
				}
			}
		}

		if (notFound) {
			System.out.println(-1);
		} else {
			System.out.println(sb.toString().trim());
		}
	}
}