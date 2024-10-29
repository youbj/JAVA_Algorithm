import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        
        Arrays.sort(citations);
        int max = citations[size-1];
        
        for(int i=0;i<max;i++){
            int cnt = 0;
            for(int j=0;j<size;j++){
                if(i <= citations[j]){
                    cnt++;
                }
            }
            
            if(cnt>=i){
                answer =Math.max(i,answer);
            }
        }
        return answer;
    }
}