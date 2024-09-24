import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int INF = 1000000000;

    public static int n, e;
    public static ArrayList<Edge>[] edges;
    public static int node1, node2;

    public static void main(String[] args) throws Exception {
        init();
        long answer = exec();

        System.out.println(answer);
    }

    public static long exec() {
        long[] distFromStart = dijkstra(1);
        long[] distFromNode1 = dijkstra(node1);
        long[] distFromNode2 = dijkstra(node2);

        long path1 = distFromStart[node1] + distFromNode1[node2] + distFromNode2[n];
        long path2 = distFromStart[node2] + distFromNode2[node1] + distFromNode1[n];

        long result = Math.min(path1, path2);

        return (result >= INF) ? -1 : result;
    }

    public static long[] dijkstra(int start) {
        long[] dist = new long[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.end;
            long currentDist = current.weight;

            if (dist[currentNode] < currentDist) {
                continue;
            }

            for (Edge next : edges[currentNode]) {
                int nextNode = next.end;
                long nextDist = currentDist + next.weight;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.offer(new Edge(nextNode, nextDist));
                }
            }
        }
        return dist;
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[start].add(new Edge(end, weight));
            edges[end].add(new Edge(start, weight));
        }
        st = new StringTokenizer(br.readLine());

        node1 = Integer.parseInt(st.nextToken());
        node2 = Integer.parseInt(st.nextToken());
    }

    public static class Edge implements Comparable<Edge> {
        int end;
        long weight;

        public Edge(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}