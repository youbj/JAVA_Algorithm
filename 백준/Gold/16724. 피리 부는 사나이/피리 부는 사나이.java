import java.util.*;

public class Main {
    static int n, m;
    static char[][] grid;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> directionMap = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];
        visited = new int[n][m];

        directionMap.put('U', 0);
        directionMap.put('D', 1);
        directionMap.put('L', 2);
        directionMap.put('R', 3);
        
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }

        int id = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j, id);
                    id++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            if (visited[cx][cy] == id) {
                count++;
                return;
            }
            if (visited[cx][cy] != 0) {
                return;
            }
            visited[cx][cy] = id;

            int dir = directionMap.get(grid[cx][cy]);
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            queue.add(new int[]{nx, ny});
        }
    }
}