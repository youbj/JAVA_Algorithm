import java.util.*;
class Solution {
	
	public int solution(int n, int[][] costs) {
        int answer = 0;
        int [][] graph = new int[n][n];
        
        for(int i=0;i<costs.length;i++) {
        	graph[costs[i][0]][costs[i][1]] = costs[i][2];
        	graph[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean [] visited = new boolean[n];
        for(int i=1;i<n;i++) {
            if(graph[0][i]==0)continue;
        	que.offer(new Node(i,graph[0][i]));
        }
        
        visited[0] = true;
        while(!que.isEmpty()) {
        	Node now = que.poll();
        	
        	if(visited[now.end]) continue;
            // System.out.println(now.weight);
        	visited[now.end] = true;
        	answer+=now.weight;
        	
        	for(int i=0;i<n;i++) {
        		if(graph[now.end][i]==0 || visited[i]) continue;
        		que.offer(new Node(i,graph[now.end][i]));
        	}
        }
        
        return answer;
    }
	public class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}