import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            System.out.println(findNextPrime(n));
        }
        scanner.close();
    }

    // n보다 크거나 같은 첫 번째 소수를 찾는 함수
    private static long findNextPrime(long n) {
        if (n <= 1) return 2;
        long candidate = n;
        while (!isPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    // 소수 판별 함수
    private static boolean isPrime(long number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (long i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}