package baekjoon_1654;

import java.util.*;
import java.io.*;

public class Solution_1654 {
	public static int []arr;
	public static void main(String[]arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int k,n;
		k=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		arr=new int[k];
		long sum=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<k;i++) {
			int leng=Integer.parseInt(br.readLine());
			arr[i]=leng;
			sum+=leng;
			if(min>leng)
				min=leng;
		}
		int avg=(int)Math.min(sum/n, Integer.MAX_VALUE);
		int check=Math.min(avg, min);
		boolean cond=true;
		while(cond) {
			int count=0;
			for(int a:arr) {
				count+=a/check;
				if(count>=n) {
					cond=false;
					count++;
					break;
				}
			}
			check--;
		}
		System.out.println(check);
		
		
	}
}
