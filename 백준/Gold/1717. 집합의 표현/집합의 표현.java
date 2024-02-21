import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int node;
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		makeSet() ;
		
		for(int i=0;i<edge;i++) {
			excute();	
		}
		System.out.println(sb.toString());
	}
	
	public static void excute() throws IOException{
		st = new StringTokenizer(br.readLine());
		int cmd = Integer.parseInt(st.nextToken());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		if(cmd==0) {
			Union(num1,num2);
		}
		else {
			findSet(num1, num2);
		}
	}
	
	public static void makeSet() {
		parent = new int[node+1];
		
		for(int i=1;i<node+1;i++) {
			parent[i]=i;
		}
	}
	
	public static boolean Union(int a,int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA==rootB) {
			return false;
		}
		
		parent[rootB]=rootA;
		
		return true;
	}
	
	public static int findSet(int num) {
		if(parent[num]==num)
			return num;
		return findSet(parent[num]);
	}
	public static void findSet(int a,int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA==rootB)
			sb.append("YES").append("\n");
		else
			sb.append("NO").append("\n");		
	}
}