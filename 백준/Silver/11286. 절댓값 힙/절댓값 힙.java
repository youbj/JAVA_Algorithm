import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int index=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int n=Integer.parseInt(br.readLine());
		PriorityQueue<check> que=new PriorityQueue<>((p1,p2)-> {
			if(p1.abs==p2.abs) { 
				return Integer.compare(p1.num, p2.num);
			}else {
				return Integer.compare(p1.abs, p2.abs);
			}
		});
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());		
			if(num==0) {
				if(que.isEmpty())
					sb.append(0+"\n");
				else
					sb.append(que.poll().num+"\n");
			}	
			else
				que.add(new check(num));
		}
		System.out.print(sb.toString());
	}
	
	public static class check{
		int num;
		int abs;
		check(int num){
			this.num=num;
			this.abs=Math.abs(num);
		}
	}
	
}