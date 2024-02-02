import java.util.*;
/**
 * @author	유병주 
 * @date 	02.02
 * @link	https://www.acmicpc.net/problem/2164
 * @keyword_solution  queue를 사용하여 출력
 * @input int형 정수가 들어가기 때문에 신경써야할 부분이 없다.
 * @output   queue를 사용하여 마지막남은 값 출력
 * @time_complex  O(N)
 * @perf 26032	284
 */

public class Main {
	public static void main(String[] args) {
		Queue<Integer> que=new ArrayDeque<>();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n==1){
            System.out.println(1);
            return;
        }
			
		for(int i=1;i<=n;i++) {
			if(i%2==0)
				que.add(i);
		}
		
		if(n%2!=0) {
			while(que.size()!=1) {
				que.add(que.poll());
				que.poll();
			}
		}
		else {
			while(que.size()!=1) {
				que.poll();
				que.add(que.poll());
			}
		}
		System.out.println(que.poll());
		sc.close();
	}
}