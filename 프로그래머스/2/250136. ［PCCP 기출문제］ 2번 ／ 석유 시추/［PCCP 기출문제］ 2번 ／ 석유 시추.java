import java.util.*;

class Solution {
    public class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] oils;
    
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        
        oils = new int[col];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (land[r][c] == 1) {
                    sichu(new Point(r, c), land);
                }
            }
        }
        
        int answer = 0;
        for (int oil : oils) {
            answer = Math.max(answer, oil);
        }
        
        return answer;
    }
    
    public void sichu(Point p, int[][] land) {
        Queue<Point> que = new ArrayDeque<>();
        que.offer(p);
        land[p.r][p.c] = 0;
        
        int row = land.length;
        int col = land[0].length;
        boolean[] isVisited = new boolean[col];
    
        int count = 0;
        while (!que.isEmpty()) {
            Point now = que.poll();

            isVisited[now.c] = true;
            count++;

        
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
            
                if (nr >= 0 && nc >= 0 && nr < row && nc < col && land[nr][nc] == 1) {
                    land[nr][nc] = 0;
                    que.offer(new Point(nr, nc));
                }
            }
        }
    
        for (int i = 0; i < col; i++) {
            if (isVisited[i]) {
                oils[i] += count;
            }
        }
    }
}