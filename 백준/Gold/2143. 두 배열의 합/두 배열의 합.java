import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		HashMap<Integer, Integer> mapA = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mapB = new HashMap<Integer, Integer>();

		int t = Integer.parseInt(br.readLine());

		int sizeA = Integer.parseInt(br.readLine());
		int arrA[] = new int[sizeA];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < sizeA; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < sizeA; i++) {
			int sum = 0;

			for (int j = i; j < sizeA; j++) {
				sum += arrA[j];
				mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
			}
		}
		
		
		int sizeB = Integer.parseInt(br.readLine());
		int[] arrB = new int[sizeB];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < sizeB; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		long count = 0;

		for (int i = 0; i < sizeB; i++) {
			int sum = 0;
			for (int j = i; j < sizeB; j++) {
				sum += arrB[j];
				if (mapA.containsKey(t - sum)) {
					count+=mapA.get(t-sum);
				}
			}
		}
		System.out.println(count);
		
	}

}