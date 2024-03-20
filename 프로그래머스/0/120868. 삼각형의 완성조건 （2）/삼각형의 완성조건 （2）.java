import java.util.*;
class Solution {
    public boolean [] selected;
    public int [] buffer;
    HashSet<Integer>set = new HashSet<>();
    
    public int solution(int[] sides) {
        int answer = 0;
        
        //기존에 있는 배열에서 2개 고르기 
        buffer = new int[2];
        selected = new boolean[sides.length];
        makeCnt(0,0,sides);
        
        answer = set.size();

        return answer;
    }
    
    public void makeCnt(int cnt,int idx,int[] sides){
        if(idx == 2){
            calc();
            return;
        }
        
        for(int i=cnt;i<sides.length;i++){
            buffer[idx]= sides[i];
            makeCnt(i+1,idx+1,sides);
            makeCnt(i+1,idx,sides);           
        }
    }
    
    public void calc(){
        int large = Math.max(buffer[0],buffer[1]);
        int small = Math.min(buffer[0],buffer[1]);
        
        //  둘 중에 더 큰 수 가 있을 경우
        for(int i=large-small+1;i<=large;i++){
            set.add(i);
        }System.out.println();
        //  더 큰수가 들어오는 경우
        for(int i=large+1;i<large+small;i++){
            set.add(i);
        }
    }
    
}