import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author 	유병주
 * @date 	02.01
 * @link	https://www.acmicpc.net/problem/12891
 * @keyword_solution  
 * 슬라이딩 윈도우 
 * 원래 for문의 반복으로 구현했으나 시간초과가 발생해 인덱스를 사용하여 인덱스를 하나씩 증가하며 데이터를 추가, 맨앞 데이터를 삭제하는 방식인
 * 슬라이딩 윈도우로 해결 
 * @input 
 * 1000000 이하이므로 1000000을 10씩 만든다하면 for문 사용시 10만번 반복해야하며 그 사이에 필수 문자체크까지 한다면 그 이상으로 증가해
 * 제한시간안에 해결 불가능
 * @output   
 * p_len에 해당하는 문자열이 암호문으로 사용가능하면 answer를 증가시켜 출력
 * @time_complex  O(N)
 * @perf 
 */
public class Main {

	static int s_len;
	static int p_len;
	static char[] DNA;
	static int[] checkArr = new int[4];
	static int[] myArr = new int[4];
	static int checkCnt = 0; 
	static int answer = 0; 

	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s_len = Integer.parseInt(st.nextToken());
		p_len = Integer.parseInt(st.nextToken());
		DNA = br.readLine().toCharArray(); 
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p_len; i++) { 
			if (DNA[i]=='A') myArr[0]++;
			if (DNA[i]=='C') myArr[1]++;
			if (DNA[i]=='G') myArr[2]++;
			if (DNA[i]=='T') myArr[3]++;
		}

		if (checkCounting())
			answer++; 
		
		int i = -1;

		for (int j = p_len; j < s_len; j++) { 
			i = j - p_len; 
			

			if (DNA[i]=='A') myArr[0]--;
			if (DNA[i]=='C') myArr[1]--;
			if (DNA[i]=='G') myArr[2]--;
			if (DNA[i]=='T') myArr[3]--;
			
			if (DNA[j]=='A') myArr[0]++;
			if (DNA[j]=='C') myArr[1]++;
			if (DNA[j]=='G') myArr[2]++;
			if (DNA[j]=='T') myArr[3]++;
			
			if (checkCounting())
				answer++; 
		}

		System.out.println(answer);

	}

	public static boolean checkCounting() {
		for (int i = 0; i < 4; i++) {
			if (myArr[i] < checkArr[i])
				return false;
		}
		return true;
	}

}