import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[10001];
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			arr[a]++;
		}
		
		for(int i=1;i<10001;i++) {
			for(int j=0;j<arr[i];j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}