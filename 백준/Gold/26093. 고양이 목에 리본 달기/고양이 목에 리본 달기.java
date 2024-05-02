import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][k + 1]; 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(n, k, a));
    }

    public static int solve(int n, int k, int[][] a) {
        int[] pmx = new int[k + 1];
        int[] smx = new int[k + 1];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int[] tempDp = new int[k + 1]; 
            for (int j = 0; j < k; j++) {
                tempDp[j] = a[i][j] + Math.max(j > 0 ? pmx[j - 1] : 0, j < k - 1 ? smx[j + 1] : 0);
            }
            for (int j = 0; j < k; j++) {
                pmx[j] = Math.max(j > 0 ? pmx[j - 1] : 0, tempDp[j]);
                smx[k - j - 1] = Math.max(smx[k - j], tempDp[k - j - 1]);
            }
            dp = tempDp;
        }

        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max; 
    }
}