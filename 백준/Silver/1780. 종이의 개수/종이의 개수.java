import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int size;
    static int[][] coloredpaper;
    static int[] answer = new int[3];

    public static void main(String[] args) throws Exception {
        size = Integer.parseInt(br.readLine());
        coloredpaper = new int[size + 1][size + 1];

        for (int r = 1; r <= size; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= size; c++) {
                coloredpaper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        PaperCheck(1, 1, size);

        for (int ans : answer) {
            System.out.println(ans);
        }
    }

    public static void PaperCheck(int row, int col, int maxSize) {
        if (check(row, col, maxSize)) {
            answer[coloredpaper[row][col] + 1]++;
            return;
        }

        int newSize = maxSize / 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                PaperCheck(row + r * newSize, col + c * newSize, newSize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int value = coloredpaper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (coloredpaper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}