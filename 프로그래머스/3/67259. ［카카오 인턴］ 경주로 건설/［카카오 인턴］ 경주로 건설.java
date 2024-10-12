import java.util.*;

class Solution {
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        return exec(board);
    }
    
    public int exec(int[][] board) {
        int size = board.length;
        int[][][] visited = new int[size][size][2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited[i][j][0] = visited[i][j][1] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<Point> que = new PriorityQueue<>();
        que.offer(new Point(0, 0, 0, -1));
        
        while (!que.isEmpty()) {
            Point now = que.poll();
            
            if (now.r == size - 1 && now.c == size - 1) {
                return now.cost;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (isCant(nr, nc, size) || board[nr][nc] == 1) {
                    continue;
                }
                
                int newCost = now.cost + 100;
                int newDir = (i < 2) ? 0 : 1;
                
                if (now.dir != -1 && now.dir != newDir) {
                    newCost += 500;
                }
                
                if (newCost < visited[nr][nc][newDir]) {
                    visited[nr][nc][newDir] = newCost;
                    que.offer(new Point(nr, nc, newCost, newDir));
                }
            }
        }
        return -1;
    }
    
    public boolean isCant(int r, int c, int size) {
        return r < 0 || c < 0 || r >= size || c >= size;
    }
    
    public class Point implements Comparable<Point> {
        int r, c;
        int cost, dir;
        
        public Point(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
        
        public int compareTo(Point o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}