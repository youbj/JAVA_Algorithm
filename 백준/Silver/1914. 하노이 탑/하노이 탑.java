import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;

public class Main {
	
	static StringBuffer sb=new StringBuffer();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		BigInteger count=new BigInteger("2").pow(n).subtract(BigInteger.ONE);
		System.out.println(count);
		
		if(n<=20) {
			hanoi(n,1,3,2);
			System.out.println(sb.toString());
		}
		br.close();
	}
	
	public static void hanoi(int n,int from,int to, int via) {
		if(n==1) {
			sb.append(from+" "+to+"\n");
		}
		else {
			hanoi(n-1,from,via,to);
			sb.append(from+" "+to+"\n");
			hanoi(n-1,via,to,from);
		}
	}
}