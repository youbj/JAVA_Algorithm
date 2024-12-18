import java.util.*;

class Solution {
    public int[][] map;
    public boolean[][] isvisited;
    public int row, col;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        init(maps);
        List<Integer> sumList = new ArrayList<>();
        
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(!isvisited[r][c] && map[r][c] != 0) {
                    sumList.add(exec(r, c, 0));
                }
            }
        }
        
        if(sumList.isEmpty()) return new int[]{-1};
        
        Collections.sort(sumList);
        return sumList.stream().mapToInt(i -> i).toArray();
    }
    
    public int exec(int r, int c, int sum) {
        if(r < 0 || r >= row || c < 0 || c >= col || 
           isvisited[r][c] || map[r][c] == 0) return 0;
        
        isvisited[r][c] = true;
        sum = map[r][c];
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            sum += exec(nr, nc, 0);
        }
        
        return sum;
    }
    
    public void init(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        map = new int[row][col];
        isvisited = new boolean[row][col];
        
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                char ch = maps[r].charAt(c);
                if(ch == 'X') continue;
                map[r][c] = ch - '0';
            }
        }
    }
}