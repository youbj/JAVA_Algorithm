import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int edge;
	
	static HashMap<String, Integer> map;
	static int [] parent;
	
	public static void main(String[] args) throws Exception{
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testcase;tc++) {
			edge = Integer.parseInt(br.readLine());
			
			makeSet();
			
			for(int i=0;i<edge;i++) {
				st = new StringTokenizer(br.readLine());
				String fr1 = st.nextToken();
				String fr2 = st.nextToken();
				
				int ans = Union(getIdx(fr1), getIdx(fr2));
				sb.append(ans).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int getIdx(String str) {
		Integer idx = map.get(str);
		
		if(idx ==null) {
			idx = map.size();
			map.put(str, idx);
		}
		
		return idx;
	}
	
	public static void makeSet() {
		parent = new int[edge*2];
		map = new HashMap<>();
		
		for(int i=0;i<edge*2;i++) {
			parent[i] =-1;
		}
		
	}
	
	public static int Union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA==rootB)
			return -parent[rootA];
		
		parent[rootA] += parent[rootB];
		parent[rootB] = rootA;
		
		return -parent[rootA];
	}
	
	public static int findSet(int a) {
		if(parent[a]<0)
			return a;
		
		return parent[a] = findSet(parent[a]);
	}
	


}