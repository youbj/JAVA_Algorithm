import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int Ingredients[][];
	static int min=Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n =Integer.parseInt(br.readLine());
		Ingredients= new int[n][2];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			Ingredients[i][0]=Integer.parseInt(st.nextToken());
			Ingredients[i][1]=Integer.parseInt(st.nextToken());
			
		}
		boolean[] choosed=new boolean[n];
		makeBitPowerSet(0,1,0,choosed);
		System.out.println(min);
	}
	
	public static void makeBitPowerSet(int toCheck,int sour,int bitter, boolean[]choosed) {
		if(toCheck==n) {
			if(bitter==0)
				return;
			min=Math.min(min,Math.abs(sour-bitter));
			return;
		}
		
		choosed[toCheck]=true;
		makeBitPowerSet(toCheck+1,sour*Ingredients[toCheck][0],bitter+Ingredients[toCheck][1],choosed);		
		choosed[toCheck]=false;
		makeBitPowerSet(toCheck+1,sour,bitter,choosed);
	}
}