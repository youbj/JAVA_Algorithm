import java.util.*;
class Solution {
    public boolean [] visited;
    public int ans=0;
    public int solution(int n, int[][] computers) {
        visited = new boolean [n];
        int answer = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i])
                bfs(computers,i,n);
        }
        return ans;
    }
    
    public void bfs(int[][]computers,int num,int n){
        Queue<Integer>que = new ArrayDeque<>();
        que.offer(num);
        ans++;
        
        while(!que.isEmpty()){
            int now = que.poll();
            if(visited[now])
                continue;
            visited[now] = true;
            
            for(int i=0;i<n;i++){
                if(computers[now][i]==1&&!visited[i]){ 
                    que.offer(i);
                }
            }
        }
    }
}