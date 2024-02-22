import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int node;
	static int edge;
	static int capital;
	
	static int [] money;
	static int [] parent;
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		capital = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=node;i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			Union(friend1,friend2);
		}
		for(int i=1;i<node+1;i++) {
			int key = findSet(i);
			set.add(key);
		}
		
		int moneySum=0; 
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			moneySum+=money[it.next()];
			if(moneySum>capital) {
				System.out.println("Oh no");
				break;
			}
		}
		if(moneySum<=capital) {
			System.out.println(moneySum);
		}
	}
	
	public static void makeSet() {
		parent = new int [node+1];
		money = new int [node+1];
		
		for(int i=1;i<=node;i++) {
			parent[i] = i;
		}
	}
	
	public static boolean Union(int a,int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA ==rootB)
			return false;
		
		if(money[rootA] > money[rootB]) {
			int buf=rootA;
			rootA = rootB;
			rootB = buf;
		}
		
		parent[rootB] = rootA;
		money[rootB] = money[rootA];
		return true;
	}
	
	public static int findSet(int num) {
		if(parent[num]== num)
			return num;
		return parent[num] = findSet(parent[num]);
	}
	
}