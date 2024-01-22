//
//
//import java.io.BufferedReader;
//
//import java.io.IOException;
//
//import java.io.InputStreamReader;
//
//import java.util.StringTokenizer;
//
//
//
//public class Solution_9095 {
//
//	public static void main(String[]args) throws IOException {
//
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st= new StringTokenizer(br.readLine());
//
//		int T=Integer.parseInt(st.nextToken());
//
//		int [] numbers=new int[T];
//
//		
//
//		int max=Integer.MIN_VALUE;
//
//		
//
//		for(int i=0;i<T;i++) {
//
//			st= new StringTokenizer(br.readLine());
//
//			numbers[i]=Integer.parseInt(st.nextToken());
//
//			if(max<numbers[i]) {
//
//				max=numbers[i];
//
//			}
//
//		}
//
//		int []dp=new int[max+1];
//
//		dp[0]=1;
//
//		dp[1]=1;
//
//		dp[2]=2;
//
//		
//
//		for(int i=3;i<=max;i++) {
//
//			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
//
//		}
//
//		
//
//		for(int i=0;i<T;i++) {
//
//			System.out.println(dp[numbers[i]]);
//
//		}
//
//		
//
//	}
//
//}
