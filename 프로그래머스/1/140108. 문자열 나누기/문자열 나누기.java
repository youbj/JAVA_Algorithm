import java.util.*;
import java.lang.*;

class Solution {
    char std;
    int count_std = 0;
    int count_notstd = 0;
    
    public int solution(String s) {
        int answer = 1;
        
        count_std++;
        std=s.charAt(0);
        
        for(int i=1;i<s.length();i++){
            if(count_std==count_notstd){
                count_std=1;
                count_notstd=0;
                std=s.charAt(i);
                answer++;
                continue;
            }             
            if(s.charAt(i)==std){
                count_std++;
            }
            else{
                count_notstd++;
            }
        }
        
        return answer;
    }
}