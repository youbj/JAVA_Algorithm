import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static final int INF = 100000000;
    public static int n, edge;
    public static ArrayList<City> times = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        init();
        long[] answer = bellmanFord();

        if (answer == null) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                if (answer[i] == INF)
                    System.out.println("-1");
                else
                    System.out.println(answer[i]);
            }
        }
    }

    public static long[] bellmanFord() {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            for (City city : times) {
                if (dist[city.startNode] != INF && dist[city.endNode] > dist[city.startNode] + city.weight) {
                    dist[city.endNode] = dist[city.startNode] + city.weight;
                }
            }
        }

        for (City city : times) {
            if (dist[city.startNode] != INF && dist[city.endNode] > dist[city.startNode] + city.weight) {
                return null;
            }
        }

        return dist;
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            times.add(new City(startNode, endNode, weight));
        }
    }

    public static class City {
        int startNode, endNode, weight;

        public City(int startNode, int endNode, int weight) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }
    }
}