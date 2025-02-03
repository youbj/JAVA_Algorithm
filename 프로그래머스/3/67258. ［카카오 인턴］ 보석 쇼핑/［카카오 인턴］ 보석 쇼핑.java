import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int typeCount = gemTypes.size();
        
        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0;
        int minLength = gems.length;
        
        for(int end = 0; end < gems.length; end++) {
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            
            while(gemCount.size() == typeCount) {
                if(end - start < minLength) {
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                    minLength = end - start;
                }
                
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if(gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }
        }
        
        return answer;
    }
}