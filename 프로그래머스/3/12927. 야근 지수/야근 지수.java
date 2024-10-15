import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer>que = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            que.offer(works[i]);
        }
        
        while(n!=0&&!que.isEmpty()){
            int value = que.poll();
            if(value != 0){
                que.offer(value-1);
                n--;
            }
        }
        
        while(!que.isEmpty()){
            int value = que.poll();
            answer += (value*value);
        }
        return answer;
    }
}