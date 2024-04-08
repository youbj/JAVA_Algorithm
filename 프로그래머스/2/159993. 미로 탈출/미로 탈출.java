import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	public int[] dr = { -1, 1, 0, 0 };
	public int[] dc = { 0, 0, -1, 1 };
	public char[][] map;
	private int row,col;
	private Point start, lever, end;

	public int solution(String[] maps) {
		int answer = 0;
		row = maps.length;
		col = maps[0].length();
		map = new char[row][col];
        for(int r=0;r<row;r++){
            map[r] = maps[r].toCharArray();
            for(int c=0;c<col;c++){
                if(map[r][c]=='S'){
                    start = new Point(r,c,0,0);
                }
                else if(map[r][c]=='L'){
                    lever = new Point(r,c,0,1);
                }
                else if(map[r][c]=='E'){
                    end = new Point(r,c,0,1);
                } 
                else 
                    continue;
            }
        }
		answer = mapPath();
		return answer;
	}

	public int mapPath() {
		PriorityQueue<Point> que = new PriorityQueue<>();
		boolean[][][] visited = new boolean[row][col][2]; // 레버 있? 없?
		que.offer(start);
		visited[start.r][start.c][start.lev] = true;
        
        while(!que.isEmpty()){
            Point now = que.poll();
            if(now.r==end.r && now.c==end.c&&now.lev==end.lev){
                return now.cnt;
            }
            if(now.r==lever.r && now.c==lever.c){
                now.lev = lever.lev;
            }
            
            for(int i=0;i<4;i++){
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                
                if(isIn(nr,nc)) continue;
                
                if(visited[nr][nc][now.lev]) continue;
                que.offer(new Point(nr,nc,now.cnt+1,now.lev));
                visited[nr][nc][now.lev] = true;
            }
        }
        return -1;
	}

	public boolean isIn(int r, int c) {
		return r < 0 || c < 0 || r >= row || c >= col || map[r][c] == 'X';
	}

	public class Point implements Comparable<Point>{
		int r;
		int c;
		int lev;
		int cnt;

		public Point(int r, int c, int cnt, int lev) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.lev = lev;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
}
