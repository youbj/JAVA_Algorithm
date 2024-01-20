//package baekjoon_2579;
//import java.util.*;
//import java.io.*;
//
//public class Solution_2579 {
//	public static void main(String []args) throws IOException {
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		
//		int layer;
//		layer = Integer.parseInt(br.readLine());
//		int[]stairs=new int [layer+1];
//		int[] dp = new int[layer + 1];
//		
//		for(int i=1;i<=layer;i++) {
//			stairs[i]=Integer.parseInt(br.readLine());
//		}
//		
//		 dp[1] = stairs[1];
//	        if (layer >= 2) {
//	            dp[2] = stairs[1] + stairs[2];
//	        }
//
//	        for (int i = 3; i <= layer; i++) {
//	            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
//	        }
//		System.out.println(dp[layer]);		
//	}
//}
