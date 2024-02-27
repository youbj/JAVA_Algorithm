import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static ArrayList<Integer> have;
	public static char [] answer;
	public static int idx=0;
	
	public static void main(String[] args) throws Exception{
		int num = Integer.parseInt(br.readLine());
		have = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			int a = Integer.parseInt(st.nextToken());
			add(a);
		}
		
		int checknum = Integer.parseInt(br.readLine());
		answer = new char[checknum];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<checknum;i++) {
			int find = Integer.parseInt(st.nextToken());
			if(have.indexOf(find)==-1) {
				answer[i] = 'N';
				continue;
			}
			answer[i] = 'Y';			
		}	
		
		for(char ans:answer) {
			System.out.print(ans+" ");
		}
	}
	
	public static void add(int a) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<idx;i++) {
			set.add(have.get(i)+a);
			set.add(Math.abs(have.get(i)-a));
		}
		set.add(a);
		for(int n:set) {
			have.add(n);
		}
		idx= have.size();
	}
}