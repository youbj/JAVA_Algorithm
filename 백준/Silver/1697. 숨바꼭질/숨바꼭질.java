import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int subin;
    static int bro;
    static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		subin=sc.nextInt();
		bro=sc.nextInt();
		
		visited=new boolean[100001];
		int result=bfs();
		System.out.println(result);
	}
	
	private static int bfs() {
		Queue<Position>que=new ArrayDeque<Position>();
		que.offer(new Position(subin,0));
		visited[subin]=true;
		
		while(!que.isEmpty()) {
			Position current= que.poll();
			int pos=current.pos;
			int time=current.count;
			
			if(pos==bro) {
				return time;
			}
			
			if(pos-1>=0&&!visited[pos-1]) {
				visited[pos-1]=true;
				que.offer(new Position(pos-1,time+1));
			}
			if(pos*2<=100000&&!visited[pos*2]) {
				visited[pos*2]=true;
				que.offer(new Position(pos*2,time+1));
			}
			if(pos+1<=100000&&!visited[pos+1]) {
				visited[pos+1]=true;
				que.offer(new Position(pos+1,time+1));
			}
		}
		return -1;
	}
	
	static class Position{
		int pos;
		int count;
		Position(){}
		Position(int pos,int count){
			this.pos=pos;
			this.count=count;
		}
	}

}