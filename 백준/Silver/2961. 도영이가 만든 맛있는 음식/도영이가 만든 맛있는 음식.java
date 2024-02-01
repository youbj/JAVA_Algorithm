import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author 유병주 
 * @date 0201
 * @link https://www.acmicpc.net/problem/2961
 * @keyword_solution  
 * 조합을 사용하여 계산
 * @input 
 * 1번줄에 재료의 갯수와 
 * 2번줄부터 재로의 개수만큼
 * 재료당 신맛과 쓴맛을 표현한 숫자가 띄어쓰기로 제공 
 * @output   
 * 조합을 통해 만들은 최솟값을 출력
 * @time_complex  
 * O(2^N)
 * @perf 
 * 14344	124
 */
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