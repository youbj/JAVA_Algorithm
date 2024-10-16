import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2)-> Integer.compare(o1[1],o2[1]));

        int end = 0;
        for(int i=0;i<targets.length;i++){
            if(end<=targets[i][0]){
                end = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}