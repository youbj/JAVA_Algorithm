import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int [] client;
	
	public static void main(String[] args) throws Exception{
		int n= Integer.parseInt(br.readLine());
		
		client = new int[n];
		for(int i=0;i<n;i++) {
			client[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(client);
		
		long sum =0;
		for(int i=n;i>0;i--) {
			int div = client[i-1]-(n-i);
			div = Math.max(0, div);
			sum+=div;
		}
		System.out.println(sum);
	}		
}