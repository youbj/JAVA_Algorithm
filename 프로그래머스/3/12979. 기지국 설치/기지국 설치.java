import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        
        for (int station : stations) {
            if (position < station - w) {
                int length = station - w - position;
                answer += Math.ceil((double) length / (2 * w + 1));
            }
            position = station + w + 1;
        }
        
        if (position <= n) {
            int length = n - position + 1;
            answer += Math.ceil((double) length / (2 * w + 1));
        }
        
        return answer;
    }
}