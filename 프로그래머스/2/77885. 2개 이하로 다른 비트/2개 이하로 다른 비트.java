class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            // 짝수인 경우
            if(x % 2 == 0) {
                answer[i] = x + 1;
            }
            // 홀수인 경우
            else {
                long bit = 1;
                while((x & bit) != 0) {
                    bit *= 2;
                }
                answer[i] = x + bit/2;
            }
        }
        
        return answer;
    }
}