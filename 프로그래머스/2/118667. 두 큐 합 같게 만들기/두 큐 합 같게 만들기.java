import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;

        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);
        }

        if((sum1 + sum2) % 2 != 0) return -1;
        
        int limit = queue1.length * 3;
        int answer = 0;
        
        while(sum1 != sum2 && answer < limit) {
            if(sum1 > sum2) {
                int val = que1.poll();
                sum1 -= val;
                sum2 += val;
                que2.offer(val);
            } else {
                int val = que2.poll();
                sum2 -= val;
                sum1 += val;
                que1.offer(val);
            }
            answer++;
        }
        
        return answer >= limit ? -1 : answer;
    }
}