import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static String S;
	public static String T;

	public static void main(String[] args) throws Exception {
		S = br.readLine();
		T = br.readLine();
		int answer = makeString();
		System.out.println(answer);
	}

	public static int makeString() {
		Set<String> visited = new HashSet<>();
		Stack<String> stack = new Stack<>();
		stack.push(T);

		while (!stack.isEmpty()) {
			String str = stack.pop();
			if (str.equals(S)) {
				return 1;
			}
			if (str.length() > S.length() && !visited.contains(str)) {
				visited.add(str);

				if (str.charAt(str.length() - 1) == 'A') {
					stack.push(str.substring(0, str.length() - 1));
				}

				if (str.charAt(0) == 'B') {
					StringBuilder sb = new StringBuilder(str.substring(1));
					stack.push(sb.reverse().toString());
				}
			}
		}

		return 0;
	}
}