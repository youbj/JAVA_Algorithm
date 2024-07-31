import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges.add(new Edge(x, y, i));
        }

        Collections.sort(edges);

        StringBuilder sb = new StringBuilder();
        boolean isPossible = true;
        for (int i = 0; i < M; i++) {
            if (i < K) {
                int score = isPossible ? kruskal() : 0;
                sb.append(score).append(" ");
                if (score == 0) isPossible = false;
            }
            if (i < M - 1) edges.remove(0);
        }

        System.out.println(sb.toString().trim());
    }

    static int kruskal() {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int totalWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.x, edge.y)) {
                totalWeight += edge.weight;
                edgeCount++;
                if (edgeCount == N - 1) break;
            }
        }

        return edgeCount == N - 1 ? totalWeight : 0;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int x, y, weight;

        Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}