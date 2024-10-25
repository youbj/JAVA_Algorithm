import java.util.*;

class Solution {
    
    public int [] dr = {1,0,-1,0};
    public int [] dc = {0,1,0,-1};
    
    public int solution(String dirs) {
        int answer = 0;
        boolean [][][] map = new boolean [11][11][4];
        
        int nowR = 5;
        int nowC = 5;
        
        for(int i=0;i<dirs.length();i++){
            
            char comm = dirs.charAt(i);    
            // System.out.println("now: ["+ nowR+", "+nowC+"] dir: "+comm+"  "+ answer);
            int nr = nowR;
            int nc = nowC;
            int dir=-1;
            switch(comm){
                case 'U':
                    nr = nowR+dr[0];
                    nc = nowC+dc[0];
                    dir = 0;
                    break;
                case 'D':
                    nr = nowR+dr[2];
                    nc = nowC+dc[2];
                    dir = 2;
                    break;
                case 'R':
                    nr = nowR+dr[1];
                    nc = nowC+dc[1];
                    dir = 1;
                    break;
                case 'L':
                    nr = nowR+dr[3];
                    nc = nowC+dc[3];
                    dir = 3;
                    break;
            }
            
            if(isOut(nr,nc))
                continue;
            
            if(!map[nr][nc][(dir+2)%4]){
                map[nr][nc][(dir+2)%4] = true;
                map[nowR][nowC][dir] = true;
                // System.out.println("now: ["+ nowR+", "+nowC+"] dir: "+(dir+2)%4+"  "+ answer);
                answer++;
            }
            
            nowR = nr;
            nowC = nc;
        }
        
        return answer;
    }
    
    public boolean isOut(int r,int c){
        return r<0||r>10||c<0||c>10;
    }
}