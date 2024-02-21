import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i] && dfs(i, 1)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static boolean dfs(int node, int depth) {
        if (depth == 5) {
            return true;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next] && dfs(next, depth + 1)) {
                return true;
            }
        }

        visited[node] = false;
        return false;
    }
}