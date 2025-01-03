class Solution {
    public int solution(int m, int n, String[] board) {

        char[][] map = new char[m][n];
        for(int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        boolean removed = true;
        
        while(removed) {
            boolean[][] willRemove = new boolean[m][n];
            removed = false;

            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(map[i][j] != '0' && 
                       map[i][j] == map[i][j+1] && 
                       map[i][j] == map[i+1][j] && 
                       map[i][j] == map[i+1][j+1]) {
                        willRemove[i][j] = true;
                        willRemove[i][j+1] = true;
                        willRemove[i+1][j] = true;
                        willRemove[i+1][j+1] = true;
                        removed = true;
                    }
                }
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(willRemove[i][j]) {
                        map[i][j] = '0';
                        answer++;
                    }
                }
            }
            
            for(int j = 0; j < n; j++) {
                for(int i = m-1; i >= 0; i--) {
                    if(map[i][j] == '0') {
                        for(int k = i-1; k >= 0; k--) {
                            if(map[k][j] != '0') {
                                map[i][j] = map[k][j];
                                map[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}