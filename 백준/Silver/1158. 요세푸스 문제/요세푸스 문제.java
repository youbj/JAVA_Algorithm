import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		Queue<Integer>que= new LinkedList<Integer>();
		
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