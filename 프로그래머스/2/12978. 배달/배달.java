import java.util.*;

class Solution {
    public final int MAX = 500_001;
    public int solution(int N, int[][] road, int K) {
        ArrayList [] map = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            map[i] = new ArrayList<Node>();
        }
        
        int answer = 0;
        
        for(int i=0;i<road.length;i++){
            int node1 = road[i][0];
            int node2 = road[i][1];
            int weight = road[i][2];
            
            map[node1].add(new Node(node2,weight));
            map[node2].add(new Node(node1,weight));
        }
        answer = exec(map,N,K);
        
        return answer;
    }
    public int exec(ArrayList [] map,int n,int k){
        int ans = 0;
        Node start =new Node(1,0);
        Queue<Node> que = new ArrayDeque<>();
        int [] nodeRoad = new int[n+1];
        
        Arrays.fill(nodeRoad,MAX);
        que.add(start);
        nodeRoad[1] = 0;
        
        while(!que.isEmpty()){
            Node now = que.poll();
        
            for(Node next: (ArrayList<Node>)map[now.end]) {
                if(nodeRoad[now.end] + next.weight < nodeRoad[next.end]) { 
                    nodeRoad[next.end] = nodeRoad[now.end] + next.weight;
                    que.offer(new Node(next.end, nodeRoad[next.end]));
                }
            }
        }
        
        for(int cnt:nodeRoad){
            if(cnt<=k)
                ans++;
        }
        
        return ans;
    }
                           
    
    public class Node{
        int end,weight;
        public Node(int end,int weight){
            this.end=end;
            this.weight = weight;
        }
    }
}