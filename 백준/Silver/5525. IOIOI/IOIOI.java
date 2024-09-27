import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int answer = 0;
        int cnt = 0;
        for (int i = 1; i < len - 1; i++) {
            if (str.charAt(i - 1) == 'I' && str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == size) {
                    answer++;
                    cnt--;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.println(answer);
    }
}