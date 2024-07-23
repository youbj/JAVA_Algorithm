import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static final int INF = 1000000000;

    public static int v, e;
    public static int[][] graph;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start][end] = weight;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j && graph[i][j] != INF && graph[j][i] != INF) {
                    answer = Math.min(answer, graph[i][j] + graph[j][i]);
                }
            }
        }

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}