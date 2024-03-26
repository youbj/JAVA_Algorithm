import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map;
	static int n;
	static int []dr = {-1,1,0,0};
	static int []dc = {0,0,-1,1};
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		int index = 1;
		while(true) {
			
			n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			sb.append("Problem ").append(index++).append(": ");
			map = new int[n][n];	
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = dijkstra();
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int dijkstra() {
        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            Arrays.fill(row, INF);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, map[0][0]));
        distance[0][0] = map[0][0];

        while (!pq.isEmpty()) {
        	Point current = pq.poll();

            if (distance[current.r][current.c] < current.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newCost = current.cost + map[nr][nc];
                    if (newCost < distance[nr][nc]) {
                        distance[nr][nc] = newCost;
                        pq.offer(new Point(nr, nc, newCost));
                    }
                }
            }
        }

        return distance[n - 1][n - 1];
    }
	
	public static boolean isIn(int r,int c) {
		return r<0||c<0||r>=n||c>=n;
	}
	public static class Point implements Comparable<Point>{
		int r;
		int c;
		int cost;
		public Point(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}