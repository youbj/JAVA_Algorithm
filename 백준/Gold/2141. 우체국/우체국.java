import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		int[][] town;
		long total = 0;

		town = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			town[i][0] = Integer.parseInt(st.nextToken());
			town[i][1] = Integer.parseInt(st.nextToken());
			total += town[i][1];
		}

		long middle = (total+1) / 2;
		Arrays.sort(town, Comparator.comparingInt(o -> o[0]));

		int postTown = -1;
		long buf = 0;
		for (int[] t : town) {
			buf += t[1];
			if (buf >= middle) {
				postTown = t[0];
				break;
			}
		}

		System.out.println(postTown);
	}
}