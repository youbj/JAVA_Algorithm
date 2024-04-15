import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static int n;
	public static List<Index> bubble;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		bubble = new ArrayList<Index>();

		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			bubble.add(new Index(value, i));
		}

		Collections.sort(bubble);

		int max = 0;
		for (int i = 0; i < n; i++) {
			int move = bubble.get(i).index - i;
			max = Math.max(max, move);
		}
		System.out.println(max + 1);
	}

	public static class Index implements Comparable<Index> {
		int value; 
		int index; 

		public Index(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Index o) {
			return Integer.compare(this.value, o.value);
		}
	}
}