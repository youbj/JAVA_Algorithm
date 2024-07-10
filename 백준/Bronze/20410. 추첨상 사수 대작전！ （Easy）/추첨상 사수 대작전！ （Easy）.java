import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        for (int a = 0; a <= m; a++) {
            for (int c = 0; c <= m; c++) {
                if ((a * seed + c) % m == x1 && (a * x1 + c) % m == x2) {
                    System.out.print(a+" "+c);
                    return;
                }
            }
        }
    }
}