import java.util.*;
class Solution {
    public final int MOD = 1_000_000_007;
    public int [] dr = {0,1};
    public int [] dc = {1,0};
    
    public int solution(int m, int n, int[][] puddles) {
        int [][] map = new int [n+1][m+1];
        
        for(int i=0;i<puddles.length;i++){
            int c = puddles[i][0];
            int r = puddles[i][1];
            map[r][c] = -1;
        }
        
        map[1][1] = 1;
        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= m; c++){
                if(r==1&&c==1)
                    continue;
                
                if(map[r][c] == -1){
                    map[r][c] = 0;
                    continue;
                }
                int up = (map[r-1][c] == -1) ? 0 :map[r-1][c];

                int left = (map[r][c-1] == -1) ? 0 : map[r][c-1];
                
                map[r][c] = (up+left) % MOD;
            }
        }
        
        
        return map[n][m];
    }
    
}