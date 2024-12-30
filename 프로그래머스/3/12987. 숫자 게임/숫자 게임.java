import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxB=0;
        int idxA = 0;
        while(idxB<B.length){
            if(A[idxA]<B[idxB]){
                answer++;
                idxB++;
                idxA++;
            }
            else{
                idxB++;
            }
        }
        
        return answer;
    }
}