import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb=new StringBuilder();
	
	public static class Node{
		private String data;
		public Node nextNode;
		public Node prevNode;
		Node(){
			this.data=null;
			this.nextNode=null;
			this.prevNode=null;
		}
		Node(String data){
			this.data=data;
			this.nextNode=null;
			this.prevNode=null;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
	}
	
	public static class Linklist{
		Node head;
		Node tail;
		
		Linklist(){
			head=new Node();
			tail=new Node();
			head.nextNode=tail;
			tail.prevNode=head;
		}
		
		private void insert(int index, String[] comd) {
			Node indexNode=head;
			for(int i=0;i<index;i++) {
				indexNode=indexNode.nextNode;
			}
			Node originalNextNode=indexNode.nextNode;
			for(int i=0;i<comd.length;i++) {
				Node bufferNode=new Node(comd[i]);
				indexNode.nextNode=bufferNode;
				bufferNode.prevNode=indexNode;
				indexNode=indexNode.nextNode;
			}
			indexNode.nextNode=originalNextNode;
			originalNextNode.prevNode=indexNode;
			return;
		}
		
		private void remove(int index, int end) {
			Node indexNode=head;
			for(int i=0;i<index;i++) {
				indexNode=indexNode.nextNode;
			}
			
			Node removeStartNode=indexNode;
			for(int i=0;i<=end;i++) {
				indexNode=indexNode.nextNode;
			}
			
			indexNode.prevNode=removeStartNode;
			removeStartNode.nextNode=indexNode;
			return;
		}
		
		private void add(int index,String[]comd) {
			Node lastNode=tail.prevNode;			
			for(int i=0;i<index;i++) {
				Node bufferNode=new Node(comd[i]);
				lastNode.nextNode=bufferNode;
				bufferNode.prevNode=lastNode;
				lastNode=bufferNode;
			}
			tail.prevNode=lastNode;
			lastNode.nextNode=tail;			
			return;
		}
		
		private void add_first(String comd) {
			Node lastNode=tail.prevNode;			
			Node bufferNode=new Node(comd);
			lastNode.nextNode=bufferNode;
			tail.prevNode=bufferNode;
			bufferNode.nextNode=tail;			
			return;
		}
		
		private String print() {
			int count=0;
			Node index=head.nextNode;
			String str="";
			while(count<10) {
				str+=index.data+" ";
				index=index.nextNode;
				count++;
			}
			str+="\n";		
			return str;
		}
	}
	public static void main(String[] args) throws Exception {
		for(int tc=1;tc<=10;tc++) {
			Linklist linklist=new Linklist();
			int arr_size= Integer.parseInt(br.readLine());
			
			st=new StringTokenizer(br.readLine());
			for(int size=0;size<arr_size;size++) {
				linklist.add_first(st.nextToken());
			}
			
			int command_size= Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int size=0;size<command_size;size++) {
				String command=st.nextToken();
				switch(command) {
				case "I":
					command_insert(linklist);
					break;
				case "D":
					command_remove(linklist);
					break;
				case "A":
					command_add(linklist);
					break;
				}
			}
			sb.append("#"+tc+" "+linklist.print());	
		}
		System.out.println(sb);
	}
	public static void command_insert(Linklist linklist) {
		int start_index=Integer.parseInt(st.nextToken());
		int end_index=Integer.parseInt(st.nextToken());
		String[]strs=new String[end_index];
		for(int i=0;i<end_index;i++) {
			strs[i]=st.nextToken();
		}
		linklist.insert(start_index, strs);
	}
	public static void command_remove(Linklist linklist) {
		int start_index=Integer.parseInt(st.nextToken());
		int end_index=Integer.parseInt(st.nextToken());
		linklist.remove(start_index, end_index);
	}
	public static void command_add(Linklist linklist) {
		int index=Integer.parseInt(st.nextToken());
		String[]strs=new String[index];
		for(int i=0;i<index;i++) {
			strs[i]=st.nextToken();
		}
		linklist.add(index, strs);
	}

}