import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n; //초밥 벨트에 놓인 접시 수
	static int d; // 초밥의 가짓수
	static int k; // 연속해서 먹는 접시
	static int c; //coupon number
	static int [] idxs;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
        int[] idxs = new int[n];
        int[] check = new int[d+1];

        for(int i=0;i<n;i++) 
        	idxs[i]=Integer.parseInt(br.readLine());

        int res=1;
        check[c]++;
        for(int i=0;i<k;i++) {
            if(check[idxs[i]]==0) res++;
            check[idxs[i]]++;
        }

        int cnt=res;
        for(int i=1;i<n;i++) {
            int pop = idxs[i-1];
            check[pop]--;
            if(check[pop]==0) cnt--;

            int add = idxs[(i+k-1)%n];
            if(check[add]==0) cnt++;
            check[add]++;

            res = Math.max(res,cnt);
        }

        System.out.println(res);
    }

}