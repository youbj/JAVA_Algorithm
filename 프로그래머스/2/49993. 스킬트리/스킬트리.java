import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        int cnt = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            Stack<Integer> stack = new Stack<>();
            stack.add(-1);
            String sk = skill_trees[i];
            
            for(int idx=0;idx<sk.length();idx++){
                char c = sk.charAt(idx);
                int index = skill.indexOf(c);
                
                if(!stack.isEmpty() && index!=-1){
                    if(stack.peek()+1!=index){
                        cnt++;
                        break;
                    }
                    stack.add(index);
                }
            }
        }
        answer = skill_trees.length - cnt;
        return answer;
    }
}