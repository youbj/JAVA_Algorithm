import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for(int i=0;i<3;i++) {
			sum += Long.parseLong(st.nextToken());			
		}
		System.out.println(sum);
	}
}