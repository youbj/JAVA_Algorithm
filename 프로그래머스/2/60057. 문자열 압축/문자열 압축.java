import java.util.*;
class Solution {
    public Stack<String>stack = new Stack<>();
    public int solution(String s) {
        int answer = s.length();
        int idx = 0;
        
        for(int i=1;i<=s.length()/2;i++){
            answer = Math.min(answer,compress(i,s));
        }
        
        return answer;
    }
    
    public int compress(int len,String s){
        Stack<String> stack = new Stack<>();
        int cnt = 1;
        String ans = "";
        String std = s.substring(0,len);
        
        for(int i=len;i<s.length();i+=len){
            String buffer = s.substring(i,Math.min(s.length(),i+len));
            
            if(buffer.equals(std)){
                cnt++;
            }
            else{
                if(cnt==1){
                    ans+=std;
                }
                else{
                    ans+=String.valueOf(cnt)+std;
                    cnt=1;
                }
                std = buffer;
            }
        }
        String lastNum = cnt==1?"":String.valueOf(cnt);
        ans+=lastNum+std;
        
        // System.out.println(len+" 길이의 ans: "+ans);
        
        return ans.length();
    }
}