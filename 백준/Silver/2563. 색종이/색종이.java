import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n= Integer.parseInt(br.readLine());
		int max=n*100;
		boolean [][] arr=new boolean[101][101];

		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			for(int nx=x;nx<x+10;nx++) {
				for(int ny=y;ny<y+10;ny++) {
					arr[nx][ny]=true;
				}
			}
		}
		int answer=0;
		for(int i =1;i<=100;i++) {
			for(int j =1;j<=100;j++) {
				if(arr[i][j]) ++answer;
			}
		}
		System.out.println(answer);
	}

}