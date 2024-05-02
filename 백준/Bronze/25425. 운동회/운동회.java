import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong(); // N 입력
        long M = scanner.nextLong(); // M 입력
        long a = scanner.nextLong(); // a 입력
        long K = scanner.nextLong(); // K 입력

        long max, min;

        if (a - K >= N - 1) {
            max = N;
            if ((a - K) % M == 0) min = (a - K) / M + 1;
            else min = (a - K) / M + 2;
        } else {
            max = a - K + 1;
            if (a - K == 0) min = 1;
            else if ((a - K) % M == 0) min = (a - K) / M + 1;
            else min = (a - K) / M + 2;
        }

        System.out.println(max + " " + min);
        scanner.close();
    }
}