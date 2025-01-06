import java.util.*;
class Solution {
    public int[] solution(int n) {
        int x=0,y=0;
        
        int dir = 0; // 0: down 1: right 2: left and up
        int [] dr = {1,0,-1};
        int [] dc = {0,1,-1};
        
        int [][] tower = new int[n][n];
        
        int num=1;
        int max = getNum(n);
        
        while(num <= max) {
            tower[x][y] = num++;
            
            int nx = x + dr[dir];
            int ny = y + dc[dir];
    
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || tower[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dr[dir];
                ny = y + dc[dir];
            }
        
            x = nx;
            y = ny;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(tower[r][c]!=0){
                    ans.add(tower[r][c]);
                }
            }
        }
        
        int [] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public int getNum(int n){
        int num=0;
        while(n>0){
            num+=n;
            n--;
        }
        return num;
    }
}