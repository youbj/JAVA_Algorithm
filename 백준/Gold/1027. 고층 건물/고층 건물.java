import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] building;
    public static int size;

    public static void main(String[] args) throws Exception {
        size = Integer.parseInt(br.readLine());
        building = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < size; i++) {
            answer = Math.max(exec(i), answer);
        }
        System.out.println(answer);
    }

    //빌딩 계산
    public static int exec(int idx) {
        int max = 0;
        int std_height = building[idx];

        //left
        for (int i = idx - 1; i >= 0; i--) {
            boolean canSee = true;
            for (int j = i + 1; j < idx; j++) {
                if (checkBlocked(i, building[i], idx, std_height, j, building[j])) {
                    canSee = false;
                    break;
                }
            }
            if (canSee) 
                max++;
        }

        //right
        for (int i = idx + 1; i < size; i++) {
            boolean canSee = true;
            for (int j = idx + 1; j < i; j++) {
                if (checkBlocked(idx, std_height, i, building[i], j, building[j])) {
                    canSee = false;
                    break;
                }
            }
            if (canSee)
                max++;
        }

        return max;
    }

    private static boolean checkBlocked(int x1, int y1, int x2, int y2, int x, int y) {
        return ((long) (y2 - y1) * (x - x1) <= (long) (y - y1) * (x2 - x1));
    }
}