class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(canCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    private boolean canCross(int[] stones, int k, int friends) {
        int zeroCnt = 0;
        
        for(int stone : stones) {
            if(stone < friends) {
                zeroCnt++;
                if(zeroCnt >= k) return false;
            } else {
                zeroCnt = 0;
            }
        }
        return true;
    }
}