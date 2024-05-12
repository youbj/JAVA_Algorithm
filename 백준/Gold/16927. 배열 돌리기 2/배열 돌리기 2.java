import java.util.*;
import java.io.*;

public class Main {
    
	static int N, M, R;
	static int[][] map;
    
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}

    	int nN = N;
    	int nM = M;
    	for(int i=0; i<Math.min(M, N)/2; i++) {
    		rotate(i, 2*nN + 2*nM - 4);
    		nN -= 2;
    		nM -= 2;
    	}
    	
    	print();
    }

    static void rotate(int start, int len) {
    	int cir = R % len;
        
    	for(int t=0; t<cir; t++) {
    		
    		int temp = map[start][start]; 
    		int idx = 0; 
    		
    		int x = start;
			int y = start;			
    		while(idx < 4) {
    			
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			if(nx >= start && ny >= start && nx < N-start && ny < M-start) {
    				map[x][y] = map[nx][ny];
    				x = nx;
    				y = ny;
    			} else {
    				idx++;
    			}
    		}
    		map[start+1][start] = temp;	
    	}
    	
    }
    
    static void print() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			System.out.print(map[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
	
}