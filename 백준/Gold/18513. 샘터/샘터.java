import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int well = Integer.parseInt(st.nextToken());
            visited.add(well);
            queue.offer(new int[]{well, 0});
        }

        long answer = 0;
        int[] dirs = {-1, 1};
        int houseCount = 0;

        while (!queue.isEmpty() && houseCount < K) {
            int[] current = queue.poll();
            int pos = current[0];
            int dist = current[1];

            for (int d : dirs) {
                int nextPos = pos + d;
                if (!visited.contains(nextPos)) {
                    visited.add(nextPos);
                    answer += dist + 1;
                    houseCount++;
                    if (houseCount == K) break;
                    queue.offer(new int[]{nextPos, dist + 1});
                }
            }
            if (houseCount == K) break;
        }

        System.out.println(answer);
    }
}