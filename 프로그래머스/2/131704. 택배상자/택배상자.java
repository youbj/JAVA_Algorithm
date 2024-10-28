import java.util.*;
class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> sub = new ArrayDeque<>(); 
        int answer = 0;
        int mainBox = 1;
        
        for(int target : order) { 
            while(mainBox < target) {
                sub.push(mainBox++);
            }
            
            if(mainBox == target) { 
                mainBox++;
                answer++;
            }
            else if(!sub.isEmpty() && sub.peek() == target) {  
                sub.pop();
                answer++;
            }
            else {  
                break;
            }
        }
        
        return answer;
    }
}