
/*
n개의 퍼즐 / diff= 난이도 / time_cur = 현재 퍼즐의 소요시간 / time_prev = 이전 퍼즐 소요시간
level = 숙련도

diff <= level => time_cur
diff > level => (time_cur + time_prev(단 diff를 0으로 취급)) * (diff - level) + time_cur
*/

import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1;
        int left = 0;
        int right = Arrays.stream(diffs).max().getAsInt();
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
        
            if (isPossible(diffs, times, limit, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left>0)
            answer = left;
        return answer;
    }

    private boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        long buf = 0;
    
        for (int j = 0; j < diffs.length; j++) {
            if (diffs[j] <= level) {
                buf += times[j];
            } else {
                long addTime = j > 0 ? times[j-1] : 0;
                long temp = (times[j] + addTime) * (diffs[j] - level) + times[j];
                buf += temp;
            }
        
            if (buf > limit) 
                return false;
        }
    
        return true;
    }
}