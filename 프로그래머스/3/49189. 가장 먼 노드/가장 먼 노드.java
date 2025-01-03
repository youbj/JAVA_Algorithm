import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int line[]:edge){
            graph.get(line[0]).add(line[1]);
            graph.get(line[1]).add(line[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        int maxDist = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    maxDist = Math.max(maxDist, distance[next]);
                    queue.offer(next);
                }
            }
        }
        
        for(int dist : distance) {
            if(dist == maxDist) answer++;
        }
        
        return answer;
    }
}