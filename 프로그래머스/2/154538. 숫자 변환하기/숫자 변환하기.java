import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        int answer = -1;
        PriorityQueue<Score> que = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        
        que.offer(new Score(x,0));
        
        while(!que.isEmpty()){
            Score now = que.poll();
            
            if(now.value>y || visited.contains(now.value)){
                continue;
            }
            
            visited.add(now.value);
            if(now.value==y){
                return now.cnt;
            }
            
            que.offer(new Score(now.value*2,now.cnt+1));
            que.offer(new Score(now.value*3,now.cnt+1));
            que.offer(new Score(now.value+n,now.cnt+1));
        }
        
        return answer;
    }
    
    public class Score implements Comparable<Score>{
        int value, cnt;
        public Score(int value,int cnt){
            this.value = value;
            this.cnt = cnt;
        }
        
        public int compareTo(Score o){
            return Integer.compare(this.cnt,o.cnt);
        }
    }
}