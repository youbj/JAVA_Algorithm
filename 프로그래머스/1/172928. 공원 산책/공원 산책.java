import java.util.*;
import java.io.*;

class Solution {
		StringTokenizer st;
		public int row, col;
		public char [][] map;
		public int nowr,nowc;
    
		public int[] solution(String[] park, String[] routes) {
			int[] answer = new int[2];
			row = park.length;
			col = park[0].length();
            map = new char[row][col];
			for(int r=0;r<row;r++) {
				map[r] = park[r].toCharArray();
				for(int c=0;c<col;c++) {
					if(map[r][c]=='S') {
						nowr = r;
						nowc = c;
					}
				}
			}
			
			for(int i=0;i<routes.length;i++) {
				st = new StringTokenizer(routes[i]," ");
				char dir = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				checkpath(nowr,nowc,dir,n);
			}
            answer[0] = nowr;
            answer[1] = nowc;
			
			return answer;
		}

		public boolean checkpath(int r, int c, char dir, int n) {
			int [] dr = {-1,1,0,0};
			int [] dc = {0,0,-1,1};
			int nr = r;
			int nc = c;
			switch (dir) {
			case 'N':
				for(int i=0;i<n;i++) {
					nr += dr[0];
					nc += dc[0];
					
					if(isIn(nr,nc) || map[nr][nc]=='X') return false;
				}
				nowr = r+(dr[0]*n);
				break;
			case 'S':
				for(int i=0;i<n;i++) {
					nr += dr[1];
					nc += dc[1];
					
					if(isIn(nr,nc) || map[nr][nc]=='X') return false;				
				}
				nowr = r+(dr[1]*n);
				break;
			case 'W':
				for(int i=0;i<n;i++) {
					nr += dr[2];
					nc += dc[2];
					
					if(isIn(nr,nc) || map[nr][nc]=='X') return false;
				}
				nowc = c+(dc[2]*n);
				break;
			case 'E':
				for(int i=0;i<n;i++) {
					nr += dr[3];
					nc += dc[3];
					
					if(isIn(nr,nc) || map[nr][nc]=='X') return false;
				}
				nowc = c+(dc[3]*n);
				break;
			}			

			return true;
		}
		
		public boolean isIn(int r,int c) {
			return r<0||c<0||r>=row||c>=col;
		}
	}