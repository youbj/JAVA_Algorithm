import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static String[] jobs;
    static int[] powers;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int human = Integer.parseInt(st.nextToken());

        jobs = new String[size];
        powers = new int[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            jobs[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < human; i++) {
            int power = Integer.parseInt(br.readLine());
            int resultIndex = binarySearch(power);

            sb.append(jobs[resultIndex]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = powers.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (powers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}