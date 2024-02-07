import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author	유병주 
 * @date 	02.07
 * @link	https://www.acmicpc.net/problem/16935
 * @keyword_solution  
 * 배열을 돌릴때 n과 m값이 변하는 것을 잘 수정해 주어야한다.
 * @input 
 * N과 M R, 배열은 입력에 문제가 없으며 완성된 배열을 가지고 수정을 진행해야 한다.
 * @output   
 * 6개의 명령이 있으므로 6개의 함수를 생성해 진행해 StringBuilder를 통해 출력
 * @time_complex  
 * O(n^2)
 * @perf 
 * 82040	392
 */

public class Main {
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 배열의 정보 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 배열 입력
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 수행할 명령 목록
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int command = Integer.parseInt(st.nextToken());
            int x_len = arr.length;
            int y_len = arr[0].length;
            switch (command) {
                case 1:
                    arr = UpDownInversion(x_len, y_len);
                    break;
                case 2:
                    arr = SideInversion(x_len, y_len);
                    break;
                case 3:
                    arr = RightTurn(x_len, y_len);
                    break;
                case 4:
                    arr = LeftTurn(x_len, y_len);
                    break;
                case 5:
                    arr = RightShift(x_len, y_len);
                    break;
                case 6:
                    arr = LeftShift(x_len, y_len);
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int[][] UpDownInversion(int x_len, int y_len) {
        int[][] ans = new int[x_len][y_len];
        for (int i = 0; i < x_len; i++) {
            ans[x_len - i - 1] = arr[i].clone();
        }
        return ans;
    }

    public static int[][] SideInversion(int x_len, int y_len) {
        int[][] ans = new int[x_len][y_len];
        for (int i = 0; i < y_len; i++) {
            for (int j = 0; j < x_len; j++) {
                ans[j][y_len - 1 - i] = arr[j][i];
            }
        }
        return ans;
    }

    public static int[][] RightTurn(int x_len, int y_len) {
        int[][] ans = new int[y_len][x_len];
        for (int i = 0; i < x_len; i++) {
            for (int j = 0; j < y_len; j++) {
                ans[j][x_len - 1 - i] = arr[i][j];
            }
        }
        return ans;
    }

    public static int[][] LeftTurn(int x_len, int y_len) {
        int[][] ans = new int[y_len][x_len];
        for (int i = 0; i < x_len; i++) {
            for (int j = 0; j < y_len; j++) {
                ans[y_len - 1 - j][i] = arr[i][j];
            }
        }
        return ans;
    }

    public static int[][] RightShift(int x_len, int y_len) {
        int[][] ans = new int[x_len][y_len];
        int x_mid = x_len / 2;
        int y_mid = y_len / 2;

        int[][] ansOne = new int[x_mid][y_mid];
        int[][] ansTwo = new int[x_mid][y_mid];
        int[][] ansThree = new int[x_mid][y_mid];
        int[][] ansFour = new int[x_mid][y_mid];

        // 1번
        for (int i = 0; i < x_mid; i++) {
            System.arraycopy(arr[i], 0, ansOne[i], 0, y_mid);
        }
        // 2번
        for (int i = 0; i < x_mid; i++) {
            System.arraycopy(arr[i], y_mid, ansTwo[i], 0, y_len - y_mid);
        }
        // 3번
        for (int i = x_mid; i < x_len; i++) {
            System.arraycopy(arr[i], y_mid, ansThree[i - x_mid], 0, y_len - y_mid);
        }
        // 4번
        for (int i = x_mid; i < x_len; i++) {
            System.arraycopy(arr[i], 0, ansFour[i - x_mid], 0, y_mid);
        }

        // 1번자리에 4번
        for (int i = 0; i < ansFour.length; i++) {
            System.arraycopy(ansFour[i], 0, ans[i], 0, ansFour[i].length);
        }
        // 2번자리에 1번
        for (int i = 0; i < ansOne.length; i++) {
            System.arraycopy(ansOne[i], 0, ans[i], y_mid, ansOne[i].length);
        }
        // 3번자리에 2번
        for (int i = 0; i < ansTwo.length; i++) {
            System.arraycopy(ansTwo[i], 0, ans[x_mid + i], y_mid, ansTwo[i].length);
        }
        // 4번자리에 3번
        for (int i = 0; i < ansThree.length; i++) {
            System.arraycopy(ansThree[i], 0, ans[x_mid + i], 0, ansThree[i].length);
        }
        return ans;
    }

    public static int[][] LeftShift(int x_len, int y_len) {
        int[][] ans = new int[x_len][y_len];
        int x_mid = x_len / 2;
        int y_mid = y_len / 2;

        int[][] ansOne = new int[x_mid][y_mid];
        int[][] ansTwo = new int[x_mid][y_mid];
        int[][] ansThree = new int[x_mid][y_mid];
        int[][] ansFour = new int[x_mid][y_mid];

        // 1번
        for (int i = 0; i < x_mid; i++) {
            System.arraycopy(arr[i], 0, ansOne[i], 0, y_mid);
        }
        // 2번
        for (int i = 0; i < x_mid; i++) {
            System.arraycopy(arr[i], y_mid, ansTwo[i], 0, y_len - y_mid);
        }
        // 3번
        for (int i = x_mid; i < x_len; i++) {
            System.arraycopy(arr[i], y_mid, ansThree[i - x_mid], 0, y_len - y_mid);
        }
        // 4번
        for (int i = x_mid; i < x_len; i++) {
            System.arraycopy(arr[i], 0, ansFour[i - x_mid], 0, y_mid);
        }

        // 1번자리에 2번
        for (int i = 0; i < ansTwo.length; i++) {
            System.arraycopy(ansTwo[i], 0, ans[i], 0, ansTwo[i].length);
        }
        // 2번자리에 3번
        for (int i = 0; i < ansThree.length; i++) {
            System.arraycopy(ansThree[i], 0, ans[i], y_mid, ansThree[i].length);
        }
        // 3번자리에 4번
        for (int i = 0; i < ansFour.length; i++) {
            System.arraycopy(ansFour[i], 0, ans[x_mid + i], y_mid, ansFour[i].length);
        }
        // 4번자리에 1번
        for (int i = 0; i < ansOne.length; i++) {
            System.arraycopy(ansOne[i], 0, ans[x_mid + i], 0, ansOne[i].length);
        }
        return ans;
    }
}