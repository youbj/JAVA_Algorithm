import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s," ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            
            max = Math.max(max,num);
            min = Math.min(min,num);          
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        answer = sb.toString();
        return answer;
    }
}