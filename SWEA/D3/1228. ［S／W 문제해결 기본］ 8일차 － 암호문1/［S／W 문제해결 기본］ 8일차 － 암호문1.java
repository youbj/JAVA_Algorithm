import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 유병주 
 * @date  02.05
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
 * @keyword_solution  
 * LinkedList를 사용하여 명령어의 요구에 맞는 위치에 주어진 암호문을 추가한다.
 * @input 
 * 10번의 tc가 있으며 
 * 그 첫번째 줄에는 원본 암호문 10~20의 정수가 주어져 저장에 메모리 문제가 없다.
 * 세번째 줄에는 명령어의 개수 5~10의 정수가 주어지며 256mb내에 처리가능하다.
 * @output   
 * 저장된 List의 10개 만 출력한다
 * @time_complex  O(N^2)
 * @perf 19,512 kb 109 ms
 */

public class Solution {
	static class Node {
		String data;
		Node nextNode;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(String data) {
			this.data=data;
			nextNode=null;
		}
	}
	
	static class Linklist{
		Node head;
		public Linklist() {
			head = new Node();
		}
		private void insert(String str) {
			Node targetNode=new Node(str);
			Node indexNode=head;
			if(indexNode.nextNode==null) {
				indexNode.nextNode=targetNode;
				return;
			}
			else {
				while(indexNode.nextNode!=null) {
					indexNode=indexNode.nextNode;
				}
				indexNode.nextNode=targetNode;
			}
		}
		
		private void insert(int index,String[] strs) {
			Node indexNode=head;
			
			for(int i=0;i<index;i++) {
				indexNode=indexNode.nextNode;
			}
			Node bufferNode=indexNode.nextNode;
			
			for(int i=0;i<strs.length;i++) {
				Node cmd=new Node(strs[i]);
				indexNode.nextNode=cmd;
				indexNode=indexNode.nextNode;
			}
			indexNode.nextNode=bufferNode;
			return;
		}
		
		private String print() {
			int count=0;
			String answer="";
			Node indexNode=head.nextNode;
			while(count<10) {
				answer+=indexNode.data+" ";
				count++;
				indexNode=indexNode.nextNode;
			}
			return answer;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			
			Linklist list=new Linklist();
			int n=Integer.parseInt(br.readLine());	
		
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				list.insert(st.nextToken());
			}
			
			int k= Integer.parseInt(br.readLine());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				String com=st.nextToken();
				
				int index=Integer.parseInt(st.nextToken());
				int strlen= Integer.parseInt(st.nextToken());
				String []str=new String[strlen];
			
				for(int j=0;j<strlen;j++) {
					str[j]=st.nextToken();
				}
				
				list.insert(index,str);			
			}
			sb.append("#"+tc+" "+list.print()+"\n");
		}
		System.out.println(sb.toString());
	}
}