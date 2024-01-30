import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 유병주 
 * @date 0130
 * @link https://www.acmicpc.net/problem/1244
 * @keyword_solution  
 * 남학생: n의 배수 스위치 변경
 * 여학생: n을 기준으로 대칭되는 구간의 모든 스위치 변경
 * @input int 형태로 입력받아 기존의 배열을 변화시킴
 * @output int 배열형태로 출력
 * @time_complex  O(n)
 * @perf 15852	148
 */
public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int [] swit;
	static int n;
	public static void main(String[] args) throws Exception{
		n=Integer.parseInt(br.readLine());
		swit = new int [n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			swit[i]=Integer.parseInt(st.nextToken()); 
		}
		get_peoples();
		printswi();
		
	}
	
	public static void get_peoples() throws IOException{
		int number=Integer.parseInt(br.readLine());
		
		for(int i=0;i<number;i++) {
			st=new StringTokenizer(br.readLine());
			int gen=Integer.parseInt(st.nextToken());
			int index=Integer.parseInt(st.nextToken());
			switch(gen) {
			case 1:
				changeMale(index);
				break;
			case 2:
				changeFemale(index);
				break;
			}
		}
	}
	
	public static void changeFemale(int index) {
		int k=1;
		swit[index]=changer(swit[index]);
		while(index+k<=n&&index-k>0) {
			if(swit[index-k]!=swit[index+k]) {
				break;
			}
			swit[index-k]=changer(swit[index-k]);
			swit[index+k]=changer(swit[index+k]);
			++k;
		}		
	}
	public static void changeMale(int index) {
		int k=1;
		while(k*index<=n) {
			swit[k*index]=changer(swit[k*index]);
			++k;
		}
	}
	public static int changer(int num) {
		if(num==1)
			return 0;
		else
			return 1;
	}
	
	public static void printswi() {
		for(int i=1;i<=n;i++) {
			if(i%20==0) {
				System.out.println(swit[i]);
				continue;
			}
			System.out.print(swit[i]+" ");
		}
	}
}