import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int[] city;
    public static int[] inDegree;
    public static ArrayList<Integer>[] graph;
    public static int[] dp;

    public static int cityNum, edgeNum;
    public static int target;

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            init();
            execute();
        }
        System.out.println(sb.toString().trim());
    }

    public static void execute() {
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= cityNum; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
                dp[i] = city[i];
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : graph[now]) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], dp[now] + city[next]);
                if (inDegree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        sb.append(dp[target]).append("\n");
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        cityNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());

        city = new int[cityNum + 1];
        inDegree = new int[cityNum + 1];
        dp = new int[cityNum + 1];
        graph = new ArrayList[cityNum + 1];

        for (int i = 1; i <= cityNum; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cityNum; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            inDegree[end]++;
            graph[start].add(end);
        }

        target = Integer.parseInt(br.readLine());
    }
}