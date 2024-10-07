import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static int first, second;
    public static int x;

    public static void main(String[] args) throws Exception {
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            x = Integer.parseInt(line);

            x *= 10000000;
            first = 0;
            second = 0;

            int n = Integer.parseInt(br.readLine());
            int[] values = new int[n];

            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(values);
            String answer = exec(n, values);

            if (answer.equals("danger")) {
                sb.append("danger").append("\n");
            } else {
                sb.append("yes").append(" ").append(first).append(" ").append(second).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static String exec(int n, int[] values) {
        String answer = "danger";

        int first_idx = 0;
        int second_idx = n - 1;

        while (first_idx < second_idx) {
            if (values[first_idx] + values[second_idx] == x) {
                first = values[first_idx];
                second = values[second_idx];
                return "yes";
            }

            if (values[first_idx] + values[second_idx] < x) {
                first_idx++;
            }

            if (values[first_idx] + values[second_idx] > x) {
                second_idx--;
            }
        }

        return answer;
    }
}