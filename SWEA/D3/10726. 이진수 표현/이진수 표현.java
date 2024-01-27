import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int ts=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=ts;t++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			String answer="";
			
			if((m&((1<<n)-1))==((1<<n)-1))
				answer="ON";
			else
				answer="OFF";
			System.out.println("#"+t+" "+answer);
		}
	}

}