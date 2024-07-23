import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stringLen = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[] answer = new char[stringLen];

        Arrays.fill(answer, '?');

        for (int r = 0; r < row; r++) {
            String buf = br.readLine();
            for (int c = 0; c < stringLen * col; c += col) {
                for (int k = c; k < c +col; k++) {
                    if (buf.charAt(k) != '?') {
                        answer[c / col] = buf.charAt(k);
                        break;
                    }
                }
            }
        }

        for (char a : answer) {
            System.out.print(a);
        }
    }
}