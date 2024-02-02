import java.util.*;

public class Main {
	static Deque<Integer> que=new ArrayDeque<>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			que.add(i);
		}
		
		while(que.size()!=1) {
			make_care();
		}
		System.out.println(que.poll());
		sc.close();
	}
	
	public static void make_care() {
		if(que.size()==1)
			return;
		que.poll();
		que.add(que.poll());
	}
}