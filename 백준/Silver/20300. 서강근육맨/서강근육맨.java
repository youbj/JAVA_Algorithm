import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long max= -1;
	static long [] numbers;
	public static void main(String[] args) throws Exception{
		int N= Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		numbers = new long [N];
		
		for(int i=0;i<N;i++) {
			numbers[i]= Long.parseLong(st.nextToken());
		}
		Arrays.sort(numbers);
		int start =0;
		int end=N-1;
		
		if(N%2!=0) {
			max=numbers[N-1];
			end--;
		}
		checking(start,end);
		
		System.out.println(max);
		
	}
	
	public static void checking(int start,int end) {
		if(start>=end)
			return;		
		
		long sum= numbers[start]+numbers[end];
		max= Math.max(max, sum);
		
		checking(start+1,end-1);
	}
}