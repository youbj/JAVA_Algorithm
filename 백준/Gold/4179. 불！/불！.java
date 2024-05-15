import java.util.*;
import java.io.*;

public class Main {
    static int row, col;
    static char[][] map;
    static int[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static Queue<Point> fire = new LinkedList<>();
    static Queue<Point> jihoon = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        visited = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') {
                    visited[i][j] = 1;
                    jihoon.add(new Point(i, j, 0));
                }
                if (map[i][j] == 'F') {
                    fire.add(new Point(i, j, 0));
                }
            }
        }
        bfs();
    }

    static void bfs() {
        while(true) {
            moveFire();
            int result = moveJH();
            if(result == 1) {
                return;
            } else if(result == -1) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }

    static void moveFire() {
        int size = fire.size();
        for(int i=0; i<size; i++) {
            Point p = fire.poll();
            for(int j=0; j<4; j++) {
                int nr = p.r + dr[j];
                int nc = p.c + dc[j];
                if(nr >= 0 && nr < row && nc >= 0 && nc < col && map[nr][nc] != '#' && map[nr][nc] != 'F') {
                    map[nr][nc] = 'F';
                    fire.add(new Point(nr, nc, 0));
                }
            }
        }
    }

    static int moveJH() {
        int size = jihoon.size();
        if(size == 0) {
            return -1;
        }
        for(int i=0; i<size; i++) {
            Point now = jihoon.poll();
            if(now.r == 0 || now.r == row-1 || now.c == 0 || now.c == col-1) {
                System.out.println(now.cnt+1);
                return 1;
            }
            for(int j=0; j<4; j++) {
                int nx = now.r + dr[j];
                int ny = now.c + dc[j];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] != '#' && map[nx][ny] != 'F' && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    jihoon.add(new Point(nx, ny, now.cnt+1));
                }
            }
        }
        return 0;
    }
    
    static class Point {
        int r;
        int c;
        int cnt;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}