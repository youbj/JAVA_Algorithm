import java.util.Scanner;
 /**
 * @author 유병주 
 * @date 0130
 * @link https://www.acmicpc.net/submit/15649
 * @keyword_solution  재귀를 통한 입력
 * @input N, M, 깊이를 지정하여 재귀관리
 * @output Stringbuilder를 통해 출력시간 관리
 * @time_complex  
 * @perf 
 */ 
 
public class Main {
 
	public static int[] arr;
	public static boolean[] visit;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		int M = in.nextInt();
 
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
		System.out.println(sb.toString());
	}
 
	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int num : arr) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}
 
}