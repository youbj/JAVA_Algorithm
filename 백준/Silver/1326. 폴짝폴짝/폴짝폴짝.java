import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int position;
		int moves;
		Node(int position,int moves){
			this.position=position;
			this.moves=moves;
		}
	}
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(bf.readLine());	
		int [] bridge=new int[N+1];
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) {
			bridge[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(bf.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(bridge,a,b));
	}
	
	public static int bfs(int [] bridge, int a, int b) {
		boolean [] visited = new boolean[N+1];
		Queue<Node>que=new LinkedList<>();
		visited[a]=true;
		que.offer(new Node(a, 0));
		
		while(!que.isEmpty()) {
			Node now_position= que.poll();
			if(now_position.position==b) {
				return now_position.moves;
			}
			
			for(int i=1;i<=N;i++) {
				int next_position = now_position.position + i*bridge[now_position.position];
				
				if(next_position>0&&next_position<=N&&!visited[next_position]) {
					visited[next_position]=true;
					que.offer(new Node(next_position,now_position.moves+1));
				}
				
				int reverse_position = now_position.position -i*bridge[now_position.position];
				
				if(reverse_position>0&&reverse_position<=N&&!visited[reverse_position]) {
					visited[reverse_position]=true;
					que.offer(new Node(reverse_position,now_position.moves+1));
				}
			}
		}
		return -1;
	}
}