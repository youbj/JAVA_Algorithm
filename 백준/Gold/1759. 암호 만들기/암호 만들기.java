import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author	유병주 
 * @date 	02.21
 * @link	https://www.acmicpc.net/problem/1759
 * @keyword_solution  
 * 1. 그냥 조합 다 만들고 그 중 모음을 포함하는 거 출력
 * 2. UnionFind 구현
 * -> 모음을 루트로 두고 유니온 파인드? 결국 조합인데? 
 * @input 
 * @output   
 * @time_complex  
 * @perf 
 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int length;
	static int size;
	static char [] answer;
	static char [] alphabet;
	 
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		length = Integer.parseInt(st.nextToken());
		size = Integer.parseInt(st.nextToken());
		
		answer = new char [length];
		alphabet = new char [size];
		
		st = new StringTokenizer(br.readLine());	
		
		for(int i=0;i<size;i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		
		makeComb(0,0);
		
	}
	
	public static void makeComb(int cnt,int idx) {
		if(idx == length) {
			if(isOK(answer)) {
				System.out.println(String.copyValueOf(answer));
			}
			return;
		}
		
		for(int i= cnt;i<size;i++) {
			answer[idx]= alphabet[i];
			makeComb(i+1,idx+1);
		}
	}
	
	public static boolean isOK(char [] str) {
		int vo=0;
		int co=0;
		for(char ch:str) {
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				vo++;
			}
			else
				co++;
		}
		if(vo>=1&&co>=2) {
			return true;
		}
		return false;
	}
	
}