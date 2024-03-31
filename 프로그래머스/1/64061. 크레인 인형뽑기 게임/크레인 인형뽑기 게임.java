import java.util.*;

	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> result = new Stack();
	        Queue<Integer> []list = new ArrayDeque[board.length+1];
	        for(int i=0;i<=board.length;i++){
	            list[i] =  new ArrayDeque<Integer>();
	        }
	        
	        for(int c=0;c<board.length;c++){
	            for(int r=0;r<board.length;r++){
                    if(board[r][c]==0) continue;
	                list[c+1].offer(board[r][c]);
	            }
	        }
	        
	        for(int i=0;i<moves.length;i++){
                int pick = moves[i];
                if(list[pick].isEmpty()) continue;
                
                int doll = list[pick].poll();
                
                if(result.isEmpty()||result.peek()!=doll){
                    result.add(doll);
                }
                else{
                    result.pop();
                    answer+=2;
                }
            }
	        return answer;
	    }
	}