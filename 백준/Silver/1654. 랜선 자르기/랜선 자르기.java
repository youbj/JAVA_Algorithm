import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[]arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int k,n;
		k=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		int [] arr=new int[k];
		long max=0;
		
		for(int i=0;i<k;i++) {
			int leng=Integer.parseInt(br.readLine());
			arr[i]=leng;
			if(max<leng)
				max=leng;
		}
		max++;
		long mid=0;
		long min=0;
		
		while(min<max) {
			
			mid=(max+min)/2;
			
			long count=0;			
			for(int a:arr) {
				count+=a/mid;
			}
			
			if(count<n)
				max=mid;
			else
				min=mid+1;
		}
		System.out.println(min-1);
		
		
	}
}