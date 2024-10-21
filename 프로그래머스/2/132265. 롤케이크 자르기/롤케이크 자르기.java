import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> 철수 = new HashMap<>();
        Set<Integer> 동생 = new HashSet<>();

        for (int t : topping) {
            철수.put(t, 철수.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            동생.add(t);
  
            철수.put(t, 철수.get(t) - 1);
            if (철수.get(t) == 0) {
                철수.remove(t);
            }

            if (동생.size() == 철수.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}