import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
/**
 * @author 유병주
 * @date 0129
 * @link https://www.acmicpc.net/problem/1914
 * @keyword_solution 
 * 
 *  몇번 진행했는가?
 *  하노이탑의 출력을 count++로 실행하였으나 시간초과가 발생 & long으로도 감당할 수 없는 결과값
 *  -> BigInteger를 사용하여 String으로 만들어 값을 처리
 *  -> count++에서 2^n-1이라는 점화식을 사용하여 미리BigInteger에 넣어 기존 2개의 함수를 1개로 리팩토링
 *  
 *  하노이의 과정
 *  - 처음 진행을 고정시켜 1->3번으로 옮기고 2번이 비었다고 설정
 *  -> 비어있는 곳에 하노이를 이동시키고 다시 비어있음을 설정
 *  -> 반복
 *  
 *  하노이 과정 출력
 *  -> 이전의 방식에서는 class Point를 선언하여 ArrayDeque를 사용하여 값을 따로 저장
 *  -> 메모리와 시간에 문제가 있을 것이라 생각되어 StringBuilder를 사용하여 값을 String으로 
 *     모두 저장 후 출력하는 방식으로 리팩토링
 *     
 * @input 3
 * @output "7 1 3 1 2 3 2 1 3 2 1 2 3 1 3"
 * @time_complex 
 * @perf 71304	584
 */

public class Main {
	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		BigInteger count=new BigInteger("2").pow(n).subtract(BigInteger.ONE);
		System.out.println(count);
		
		if(n<=20) {
			hanoi(n,1,3,2);
			System.out.println(sb.toString());
		}
		br.close();
        
	}
	
	public static void hanoi(int n,int from,int to, int via) {
		if(n==1) {
			sb.append(from+" "+to+"\n");
		}
		else {
			hanoi(n-1,from,via,to);
			sb.append(from+" "+to+"\n");
			hanoi(n-1,via,to,from);
		}
	}
}