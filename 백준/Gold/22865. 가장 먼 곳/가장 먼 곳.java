import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Node>[] graph;
    public static int[] friend;
    public static int n;
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        
        friend = new int[3];
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            friend[i] = Integer.parseInt(st.nextToken());
        }

        int edge = Integer.parseInt(br.readLine());

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        int[][] dist = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            dist[i] = dijkstra(friend[i]);
        }

        int maxDistance = -1;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int minDistance = Math.min(Math.min(dist[0][i], dist[1][i]), dist[2][i]);
            if (minDistance > maxDistance) {
                maxDistance = minDistance;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.dest;

            for (Node next : graph[u]) {
                int v = next.dest;
                int cost = dist[u] + next.cost;

                if (cost < dist[v]) {
                    dist[v] = cost;
                    pq.add(new Node(v, cost));
                }
            }
        }

        return dist;
    }

    public static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}