import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 	유병주
 * @date 	02.28
 * @link	https://www.acmicpc.net/problem/1600
 * @keyword_solution  
 * 1. dfs를 통한 해결
 * 
 * 2. bfs를 통한 해결 
 * @input 
 * 1. dfs를 통한 해결
 * 
 * 2. bfs를 통한 해결
 * 2.0) visited 처리 없이 진행
 *  -> 예제 2번 무한 루프 
 * 2.1) visited 처리 없이 map에 move 횟수를 비교하면서 1회 차이나면 안감
 *  -> 말처럼 이동을 한 곳도 1회 적기 때문에 이동하지 않아  
 *  2
	10 2
	0 0 1 0 0 1 0 0 1 0
	0 0 1 1 0 0 0 0 1 0 해당 예제에서 10이 아닌 -1이 출력된다.
 * 2.2) visited 처리 
 *  -> 말처럼 이동을 한 곳을 방문처리하여 해당 구역으로 이동하지 않는다.
 * 2.3) map에 무엇이 방문했나 처리
 *  -> static final int 를 사용한 상수 표현을 사용하여 지나간 구역을 처리했으나 불가
 * 2.4) boolean의 3차원 배열
 *  -> x 좌표와 y좌표, 남은 말 움직임을 하나의 상태로 취급
 *  -> visited를 사용하는 이유는 좌표값이 중요한 것이 아니라 상태를 나타내는 변수를 처리하기 위함이다.
 * @output 반례 목록
1
1 1
0
정답: 0

2
10 2
0 0 1 0 0 1 0 0 1 0
0 0 1 1 0 0 0 0 1 0
정답: 10
	
1
5 5
0 1 1 0 1
0 0 1 0 1
0 1 0 1 1
0 1 0 1 0
1 1 0 1 0
정답: -1	

2
5 3
0 0 0 0 0
1 0 1 1 0
1 0 1 1 0
정답: 4	

5
6 6
0 0 0 0 0 1 
0 0 0 1 0 1 
0 1 0 0 0 1 
0 1 0 0 1 0 
0 0 0 0 0 1 
1 0 0 0 1 0
정답: 4

1
4 4
0 0 0 0
0 0 0 0
0 0 1 1
0 0 1 0
정답: 4
 * @time_complex  
 * 
 * @perf 
 * 301580	724
 */

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int jumpNum; //k
	static int row,col;
	
	static int [][] map;
	static boolean[][][] visited;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int [] jumpr = {-2,-2,-1,1,2,2,1,-1};
	static int [] jumpc = {-1,1,2,2,1,-1,-2,-2};
	
	static final int HORSE = 9;
	static final int MONKEY = 8;
	
	
	public static void main(String[] args) throws Exception{
		jumpNum = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		
		for(int r=0;r<row;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<col;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		monkeyMove();
	}
	
	public static void monkeyMove() {
		Queue<Point> que= new ArrayDeque<>();
		visited = new boolean[row][col][jumpNum+1];
		
		que.offer(new Point(0,0,0,jumpNum));		
		visited[0][0][0] = true;
		
		int answer = -1;
		
		while(!que.isEmpty()) {
			Point now = que.poll();

			if(now.r==row-1&&now.c==col-1) {
				answer = now.move;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = now.r+dr[i];
				int nc = now.c+dc[i];
			
				if(isNot(nr,nc)) continue;	
				
				if(visited[nr][nc][now.jumpcnt]) continue;
				visited[nr][nc][now.jumpcnt] =true;
						
				que.offer(new Point(nr,nc,now.move+1,now.jumpcnt));
			}
			
			if(now.jumpcnt==0) continue;

			for(int i = 0; i < 8; i++) {
				int nr = now.r+jumpr[i];
				int nc = now.c+jumpc[i];
				
				if(isNot(nr,nc)) continue;
				
				if(visited[nr][nc][now.jumpcnt-1]) continue;
				visited[nr][nc][now.jumpcnt-1] =true;
				
				que.offer(new Point(nr,nc,now.move+1,now.jumpcnt-1));
			}			
			
		}
		
		System.out.println(answer);
		return;
	}
	
	public static boolean isNot(int r,int c)  {
		return r<0 || r>=row || c<0 || c>=col || map[r][c] == 1;
	}
	
	public static class Point{
		int r;
		int c;
		int move;
		int jumpcnt;
		
		public Point(int r, int c, int move, int jumpcnt) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.jumpcnt = jumpcnt;
		}
	}
}