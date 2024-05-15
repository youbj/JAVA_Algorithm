import java.io.*;
import java.util.*;

public class Main {
	private static StringTokenizer st;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] answer = new int[10];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int answer = 0;

		for (int i = 1; i <= target; i++) {
			int var = i;
			while (var != 0) {
				if (var % 10 == n) {
					answer++;
				}
				var /= 10;
			}
		}
		System.out.println(answer);
	}
}