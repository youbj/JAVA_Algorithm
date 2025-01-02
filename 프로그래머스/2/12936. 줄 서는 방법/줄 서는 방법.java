import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> numbers = new ArrayList<>();
        long factorial = 1;

        for(int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        
        k--;
        int idx = 0;
        
        while(n > 0) {
            factorial /= n;
            int value = (int)(k / factorial);
            answer[idx++] = numbers.get(value);
            numbers.remove(value);
            
            k %= factorial;
            n--;
        }
        
        return answer;
    }
}