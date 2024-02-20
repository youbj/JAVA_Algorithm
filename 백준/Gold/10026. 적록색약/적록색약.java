import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author	유병주 
 * @date 	02.20
 * @link	https://www.acmicpc.net/problem/10026
 * @keyword_solution  
 * 1. 적록색맹이 보는 함수와 아닌 사람이 보는 함수를 두면 될 듯
 * -> BFS를 통해서 기준이 되는 문자와 같으면 해당 구역에 해당하는 boolean값을 true로 변화한다.
 * @input 
 * 오직 N과 N*N에 해당하는 문자를 받으며 N의 크기가 100까지로 작기때문에 문제없다.
 * @output
 * 함수 호출 기준을 true로 두고 있기 때문에 다른 값이면 함수를 호출하지 않으니 
 * 함수가 호출될 때마다 answer값을 증가시켜준다
 * @time_complex  
 * O(n^2)
 * @perf 
 * 12368	104
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static char [][] picture;
	static int size;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1}; 
	
	public static void main(String[] args) throws Exception{
		size = Integer.parseInt(br.readLine());
		
		picture = new char [size][size];
		
		for(int r=0;r<size;r++) {
			picture[r] = br.readLine().toCharArray(); 
		}
		
		checkingPart();
		
	}
	
	public static void checkingPart() {
		boolean [][] ordinaryVisited = new boolean[size][size];
		boolean [][] weaknessVisited = new boolean[size][size];
		int answerOrdinary=0;
		int answerWeakness=0;
		for(int r=0;r<size;r++) {
			for(int c=0;c<size;c++) {
				if(!ordinaryVisited[r][c]) {
					answerOrdinary++;
					ordinaryPerson(ordinaryVisited,new Point(r,c));
				}
				
				if(!weaknessVisited[r][c]) {
					answerWeakness++;
					colorweakness(weaknessVisited,new Point(r,c));

				}
			}
		}
		System.out.println(answerOrdinary+" "+answerWeakness);
	}
	
	//파랑 빨강 초록 구분
	public static void ordinaryPerson(boolean [][]visited, Point point) {
		Queue<Point>que = new ArrayDeque<Point>();
		que.offer(point);
		char std = picture[point.r][point.c];
		
		while(!que.isEmpty()) {
			Point current = que.poll();
			
			for(int i=0;i<4;i++) {
				int nr = current.r+dr[i];
				int nc = current.c+dc[i];
				
				if(isIn(nr,nc)) continue;
				if(visited[nr][nc] || picture[nr][nc]!=std) 
					continue;
				
				visited[nr][nc]= true;
				que.offer(new Point(nr,nc));
			}
		}
	}
	

	//파랑색만 구분
	private static void colorweakness(boolean [][]visited, Point point) {
		final int BLUE = 0;
		final int GREENRED = 1;
		Queue<Point>que = new ArrayDeque<Point>();
		que.offer(point);
		int std=GREENRED;
		
		if(picture[point.r][point.c]=='B')
			std=BLUE;
		
		while(!que.isEmpty()) {
			Point current = que.poll();
			
			for(int i=0;i<4;i++) {
				int nr = current.r+dr[i];
				int nc = current.c+dc[i];
				
				if(isIn(nr,nc)) continue;
				
				int color=GREENRED;
				if(picture[nr][nc] == 'B')
					color = BLUE;
				
				if(color!=std || visited[nr][nc]) continue;
				
				visited[nr][nc]= true;
				que.offer(new Point(nr,nc));
			}
		}

	}
	
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	private static boolean isIn(int r, int c) {
		return r<0|| r>=size||c<0||c>=size;
	}
}