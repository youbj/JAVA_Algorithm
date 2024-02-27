import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author	유병주	 
 * @date 	02.27
 * @link	https://www.acmicpc.net/problem/1149
 * @keyword_solution  
 * 이전 선택을 기억하면서 이전색상과 겹치지 않게 최소의 수를 골라야 될 것 같다.
 * @input 
 * N은 2이상 1000이하 이면서 Red Green Blue 총 3개의 값이 들어가야 한다
 * 이때 시간제한이 0.5초 이다 
 * @output   
 * 이전 색 중 더 작은값을 더해 출력
 * @time_complex  
 * O(n)
 * @perf 
 */

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final int RED=0;
	static final int GREEN=1;
	static final int BLUE=2;
	
	static int num;
	static int [][] graph;

	public static void main(String[] args) throws Exception{
		num = Integer.parseInt(br.readLine());
		graph = new int[num][3];
		
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			
			graph[i][RED] = Integer.parseInt(st.nextToken());
			graph[i][GREEN] = Integer.parseInt(st.nextToken());
			graph[i][BLUE] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<num;i++) {
			graph[i][RED] += Math.min(graph[i-1][GREEN], graph[i-1][BLUE]);
			graph[i][GREEN] += Math.min(graph[i-1][RED], graph[i-1][BLUE]);
			graph[i][BLUE] += Math.min(graph[i-1][GREEN], graph[i-1][RED]);
		}
        
		int answer = Math.min(graph[num-1][RED], graph[num-1][GREEN]);
		answer = Math.min(answer, graph[num-1][BLUE]);
		System.out.println(answer);	
	}

}