import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        int n;
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            Emp[] emps = new Emp[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                emps[i] = new Emp(first, second);
            }
            Arrays.sort(emps);

            int count = 1;
            int minSecond = emps[0].second;

            for (int i = 1; i < n; i++) {
                if (emps[i].second < minSecond) {
                    count++;
                    minSecond = emps[i].second;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static class Emp implements Comparable<Emp> {
        int first, second;

        public Emp(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Emp o) {
            return Integer.compare(this.first, o.first);
        }
    }
}