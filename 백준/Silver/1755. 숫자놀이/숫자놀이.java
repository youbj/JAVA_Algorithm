import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	static int n, m;
	static Num[] numbers;
	static String number[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new Num[m - n + 1];
		int idx = 0;

		for (int i = n; i <= m; i++) {
			String str = "";
			if (i >= 10) {
				str += number[i / 10];
				str += number[i % 10];
			} else {
				str += number[i];
			}
			numbers[idx++] = new Num(i, str);
		}
		execute();
	}

	public static void execute() {
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(numbers[i].n + " ");
		}
	}

	public static class Num implements Comparable<Num> {
		int n;
		String s;

		public Num(int n, String s) {
			this.n = n;
			this.s = s;
		}

		@Override
		public int compareTo(Num o) {
			return this.s.compareTo(o.s);
		}
	}
}