import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author 유병주	 
 * @date  02.05
 * @link https://www.acmicpc.net/problem/1158
 * @keyword_solution  Queue를 사용하여 반복
 * @input 5000이하의 K와 N
 * @output  값이 도출될 때마다 수정해야 하므로 StringBuilder를 사용
 * @time_complex  O(N^2)
 * @perf 298328	664
 */

public class Main {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		Queue<Integer>que= new ArrayDeque<Integer>();
		
		int n=sc.nextInt();
		int k= sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			que.offer(i);
		}
		sb.append("<");
		
		while(que.size()!=1) {
			for(int i=0;i<k-1;i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll()+", ");
		}
		
		sb.append(que.poll()+">");
		System.out.println(sb.toString());
	}
}