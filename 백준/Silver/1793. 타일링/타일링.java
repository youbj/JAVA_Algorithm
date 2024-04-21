import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BigInteger [] tile = new BigInteger[251];
		
		tile[0] = new BigInteger("1");
		tile[1] = new BigInteger("1");
		tile[2] = new BigInteger("3");
		for(int i=2;i<=250;i++) {
			tile[i] = tile[i-1].add(tile[i-2].multiply(BigInteger.valueOf(2)));
		}
		
		while(true) {
			String num = br.readLine();
			if(num==null||num.isEmpty()) {
				break;
			}
			sb.append(tile[Integer.parseInt(num)]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}