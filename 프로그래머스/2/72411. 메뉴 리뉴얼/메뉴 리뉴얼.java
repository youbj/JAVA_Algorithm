import java.util.*;

class Solution {
    Map<String, Integer> menuMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for (int courseLength : course) {
            menuMap.clear();
            int max = 0; 
            
            for (String order : orders) {
                combination("", order, 0, courseLength);
            }
            
            if (!menuMap.isEmpty()) {
                max = Collections.max(menuMap.values());
            }
            
            if (max >= 2) {
                for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
                    if (entry.getValue() == max) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void combination(String current, String order, int start, int courseLength) {
        if (current.length() == courseLength) {
            menuMap.put(current, menuMap.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            combination(current + order.charAt(i), order, i + 1, courseLength);
        }
    }
}
