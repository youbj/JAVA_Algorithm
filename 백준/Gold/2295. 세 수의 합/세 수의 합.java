import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int n;
	public static int[] list;
	public static HashSet<Integer> sumset = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {
		
		int answer=0;
		n = Integer.parseInt(br.readLine());
		
		list = new int[n];
		
		for(int i=0;i<n;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(list);
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				sumset.add(list[i]+list[j]);
			}
		}
		
		boolean flag = false;
		for(int k=n-1;k>=0;k--) {
			for(int z=0;z<n;z++) {
				if(sumset.contains(list[k]-list[z])) {
					answer = list[k];
					flag = true;
					break;
				}
			}
			
			if(flag) {
				break;
			}
		}
		System.out.println(answer);
	}
}