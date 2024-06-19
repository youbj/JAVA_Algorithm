import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N, K;
    public static int maxSize;
    public static int[] dura;
    public static boolean[] robot;
    public static int zero;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 최대 내구도 0 갯수 제한

        maxSize = 2 * N;
        zero = 0;
        dura = new int[maxSize];
        robot = new boolean[maxSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < maxSize; i++) {
            dura[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while (zero < K) {
            answer++;
            // 1. 벨트와 로봇 회전
            rotateBelt();

            // 2. 로봇 이동
            moveRobots();

            // 3. 로봇 올리기
            placeRobot();
        }

        System.out.println(answer);
    }

    public static void rotateBelt() {
        int lastDura = dura[maxSize - 1];
        boolean lastRobot = robot[maxSize - 1];

        for (int i = maxSize - 1; i > 0; i--) {
            dura[i] = dura[i - 1];
            robot[i] = robot[i - 1];
        }

        dura[0] = lastDura;
        robot[0] = false;

        if (robot[N - 1]) {
            robot[N - 1] = false;
        }
    }

    public static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && dura[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                dura[i + 1]--;
                if (dura[i + 1] == 0) {
                    zero++;
                }
            }
        }

        if (robot[N - 1]) {
            robot[N - 1] = false;
        }
    }

    public static void placeRobot() {
        if (dura[0] > 0) {
            robot[0] = true;
            dura[0]--;
            if (dura[0] == 0) {
                zero++;
            }
        }
    }
}