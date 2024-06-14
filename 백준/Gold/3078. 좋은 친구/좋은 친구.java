import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = br.readLine();
		}

		long answer = 0;
		HashMap<Integer, Integer> nameWindow = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int nameLen = 0;
			if (i > k) {
				nameLen = names[i - k - 1].length();
				nameWindow.put(nameLen, nameWindow.get(nameLen) - 1);
			}

			nameLen = names[i].length();
			answer += nameWindow.getOrDefault(nameLen, 0);
			nameWindow.put(nameLen, nameWindow.getOrDefault(nameLen, 0) + 1);
		}

		System.out.println(answer);
	}
}