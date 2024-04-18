import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static int n;
	public static Player[] players;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());

		players = new Player[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int score1 = Integer.parseInt(st.nextToken());
			int score2 = Integer.parseInt(st.nextToken());
			int score3 = Integer.parseInt(st.nextToken());

			players[i] = new Player(idx, score1 * score2 * score3, score1 + score2 + score3);
		}
		Arrays.sort(players);

		for (int i = 0; i < 3; i++) {
			sb.append(players[i].index).append(" ");
		}
		System.out.println(sb.toString());
	}

	public static class Player implements Comparable<Player> {
		int index;
		int scoresum;
		int score;

		public Player(int index, int score, int scoresum) {
			this.index = index;
			this.score = score;
			this.scoresum = scoresum;
		}

		@Override
		public int compareTo(Player o) {
			if (o.score == this.score) {
				if (o.scoresum == this.scoresum) {
					return Integer.compare(this.index, o.index);
				}
				return Integer.compare(this.scoresum, o.scoresum);
			}
			return Integer.compare(this.score, o.score);
		}
	}
}