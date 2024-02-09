import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지역의 수
        int M = Integer.parseInt(st.nextToken()); // 수색 범위
        int R = Integer.parseInt(st.nextToken()); // 길의 수

        int[] items = new int[N + 1]; // 각 지역의 아이템 수
        int[][] map = new int[N + 1][N + 1]; // 간선 정보 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0; // 자기 자신으로의 거리는 0
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map[a][b] = l;
            map[b][a] = l;
        }

        int result = 0;
        for (int start = 1; start <= N; start++) {
            result = Math.max(result, ItemSearch(start, N, M, map, items));
        }

        System.out.println(result);
    }

    static int ItemSearch(int start, int N, int M, int[][] map, int[] items) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.distance > distance[current.vertex]) {
                continue;
            }

            for (int next = 1; next <= N; next++) {
                if (map[current.vertex][next] != INF) {
                    int nextDistance = current.distance + map[current.vertex][next];

                    if (nextDistance <= M && nextDistance < distance[next]) {
                        distance[next] = nextDistance;
                        pq.offer(new Node(next, nextDistance));
                    }
                }
            }
        }

        int totalItems = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= M) {
                totalItems += items[i];
            }
        }

        return totalItems;
    }
}