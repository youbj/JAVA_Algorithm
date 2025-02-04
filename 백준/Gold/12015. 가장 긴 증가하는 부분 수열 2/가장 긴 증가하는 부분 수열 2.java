import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[] series;

	public static void main(String[] args) throws Exception {
		int num = Integer.parseInt(br.readLine());
		series = new int[num];
		int index =0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < num; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if (index==0 || series[index-1] < value) {
				series[index++] = value;
				continue;
			}
			else {
				int changeIdx = binarySearch(index, value);
				series[changeIdx] = value;
			}
		}
		System.out.println(index);
	}
	
	public static int binarySearch(int index, int value) {
		int start = 0;
		int end = index;
		
		
		while(start<end) {
			int mid = (start+end)/2;
			if(value>series[mid]) start = mid+1;
			else end = mid;
		}
		return end;
	}

}