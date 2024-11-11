import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;i<wires.length;i++){
            ArrayList [] map = new ArrayList [n+1];
            for(int k=0;k<=n;k++){
                map[k] = new ArrayList<Integer>();
            }
            
            for(int j=0;j<wires.length;j++){
                if(i==j)
                    continue;
                map[wires[j][0]].add(wires[j][1]);
                map[wires[j][1]].add(wires[j][0]);
            }
            int diff = countNode(map,n);
            answer = Math.min(diff,answer);
        }
        return answer;
    }
    
    public int countNode(ArrayList [] map,int n){
        PriorityQueue<Integer> que = new PriorityQueue<>();
        boolean [] isVisited = new boolean[n+1];
        
        isVisited[1] = true;
        que.offer(1);
        
        int cnt=1;
        while(!que.isEmpty()){
            int now = que.poll();
            
            for(int next: (ArrayList<Integer>)map[now]){
                if(!isVisited[next]){
                    isVisited[next] = true;
                    que.offer(next);
                    cnt++;
                }
            }
        }
        return Math.abs((n-cnt)-cnt); 
    }
}