import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;
/**
 * @author	유병주 
 * @date 	02.20
 * @link	https://www.acmicpc.net/problem/15686
 * @keyword_solution  
 * r행 c열 , 1부터 시작 최대크기 N 1<= <=N
 * 치킨거리: 집과 가장 가까운 치킨집 사이의 거리  -> 모든 집의 치킨 거리의 합
 * 0: 빈칸 1: 집 2: 치킨집
 * 각 집마다 가장 가까운 치킨집하면 될듯
 * @input
 *  
 * @output
 *    
 * @time_complex
 *   
 * @perf
 *  
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dc= {-1,1,0,0};
	static int[] dr= {0,0,-1,1};
	static int cityMaxSize;
	static int remainChicken;
	static int[][] map;
	static ArrayList<Point> home;
	static ArrayList<Point> bbq;
	static Point[] combbbq;
	
	static int homeIdx;
	static int bbqIdx;
	static int answer;
	

	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		cityMaxSize = Integer.parseInt(st.nextToken());
		remainChicken = Integer.parseInt(st.nextToken());
		
		map = new int [cityMaxSize][cityMaxSize];
		home = new ArrayList<>();
		bbq = new ArrayList<>();
		combbbq = new Point[remainChicken];
		
		answer=Integer.MAX_VALUE;
		
		for(int r=0;r<cityMaxSize;r++) {
			st= new StringTokenizer(br.readLine());
			for(int c=0;c<cityMaxSize;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]== 1) {
					home.add(new Point(r,c));
				}
				else if(map[r][c]==2) {
					bbq.add(new Point(r,c));
				}
			}
		}	
		comb(0,0);
		System.out.println(answer);
	}
	
	public static void comb(int cnt,int start) {
		if(cnt==remainChicken) {
			int value=distanceSum();
			answer=Math.min(answer, value);
			return;
		}
		
		for(int i=start;i<bbq.size();i++) {
			combbbq[cnt] = bbq.get(i);
			comb(cnt+1,i+1);
		}
	}
	
	public static int distanceSum() {
		int sum=0;
		for(int i=0;i<home.size();i++) {
			int min= Integer.MAX_VALUE;
			for(int j=0;j<remainChicken;j++) {
				min = Math.min(min, Math.abs(combbbq[j].c-home.get(i).c)+
						Math.abs(combbbq[j].r-home.get(i).r));
			}
			sum+=min;
		}
		return sum;
	}
	
	
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}

}