import java.util.Scanner;
/**
 * @author 유병주 
 * @date   01.31
 * @link   https://www.acmicpc.net/problem/15650
 * @keyword_solution  재귀를 통한 조합생성
 * @input  n까지의 수이지만 n은 8이하이기에 재귀로 충분
 * @output  println을 사용해 출력할 경우 시간이 증가할 것으로 생각되어 sb에 저장후 한번에 출력
 * @time_complex  
 * @perf 
 */
public class Main {
	static int[]arr;
	static int n,m;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n= sc.nextInt();
		m = sc.nextInt();
		arr=new int[m];
		
		comb(0,1);
		System.out.println(sb.toString());
		sc.close();
	}
	
	private static void comb(int cnt, int start) {
		if(cnt==m) {
			for(int num:arr) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<=n;i++) {
			arr[cnt]=i;
			comb(cnt+1,i+1);
		}
	}

}