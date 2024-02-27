import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int [] memory;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		memory = new int [n+1];
		Arrays.fill(memory, INF);
		memory[1] =0;
		
		for(int i=1;i<n;i++) {			
			memory[i+1] = Math.min(memory[i+1], memory[i]+1);
			
			if(i*2<=n) {
				memory[i*2] = Math.min(memory[i*2], memory[i]+1);
			}
			if(i*3<=n) {
				memory[i*3] = Math.min(memory[i*3], memory[i]+1);
			}
		}
		System.out.println(memory[n]);
	}

}