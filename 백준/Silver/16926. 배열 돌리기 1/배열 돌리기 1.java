import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, r;
	private static int[][] arr;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = Math.min(n, m)/2;
		
		for (int i=0; i<r; i++) {
			circulate(num);
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void circulate(int num) {
		
		for (int i=0; i<num; i++) {
			int x = i;
			int y = i;
			int buf = arr[x][y]; 
			
			int index = 0;
			
			while (index < 4) {
				
				int nx = x + dx[index];
				int ny = y + dy[index];
				
				if (bound_check(nx,ny,i)) {
					index++;
				} else {
					arr[x][y] = arr[nx][ny];
					
					x = nx;
					y = ny;
				}
				
			}
			arr[i+1][i] = buf;
		}
		
	}
	
	public static boolean bound_check(int nx,int ny,int i) {
		return nx < i || ny < i || nx >= n-i || ny >= m-i;
	}
}