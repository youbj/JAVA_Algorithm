import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        String advertisement = br.readLine();
       
        int minLength = getMinLength(advertisement);

        System.out.println(minLength);
    }

    private static int getMinLength(String advertisement) {
        int n = advertisement.length();
        int[] pi = new int[n];

        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];

            while (j > 0 && advertisement.charAt(i) != advertisement.charAt(j)) {
                j = pi[j - 1];
            }

            if (advertisement.charAt(i) == advertisement.charAt(j)) {
                pi[i] = j + 1;
            }
        }

        int minLength = n - pi[n - 1];
        return minLength;
    }
}