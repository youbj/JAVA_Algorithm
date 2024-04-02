import java.util.Scanner;

public class Main {
    static final long MOD = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long result = (fibonacci(b + 2) - fibonacci(a + 1) + MOD) % MOD;
        System.out.println(result);
    }

    static long fibonacci(long n) {
        long[][] F = {{1, 1}, {1, 0}};
        if (n == 0)
            return 0;
        power(F, n - 1);

        return F[0][0];
    }

    static void multiply(long[][] F, long[][] M) {
        long x = (F[0][0] * M[0][0] + F[0][1] * M[1][0]) % MOD;
        long y = (F[0][0] * M[0][1] + F[0][1] * M[1][1]) % MOD;
        long z = (F[1][0] * M[0][0] + F[1][1] * M[1][0]) % MOD;
        long w = (F[1][0] * M[0][1] + F[1][1] * M[1][1]) % MOD;

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    static void power(long[][] F, long n) {
        if (n == 0 || n == 1)
            return;
        long[][] M = {{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }
}