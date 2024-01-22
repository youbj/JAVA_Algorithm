import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int count=0;
	public static int m;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[n];
	
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());			
		}
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=i;j<n;j++) {
				sum+=arr[j];
				if(sum==m)
					count++;
				else if(sum>m)
					break;
			}
		}
				
		System.out.println(count);
	}
	

}