//package baekjoon_17070;
//
//import java.util.*;
//import java.io.*;
//
//public class Solution_17070 {
//    static int N;
//    static int[][] status;
//    static int[][] arr;
//    static int count = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        status = new int[N][N];     // 파이프의 상태(가로: 1, 세로: 2, 대각선: 3)
//        status[0][0] = status[0][1] = 1;
//
//        arr = new int[N][N];        // 집의 상태
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        dfs(0, 1, 1);
//        System.out.println(count);
//    }
//
//    public static void dfs(int x, int y, int stat) {
//        if (x == N - 1 && y == N - 1) {
//            count++;
//            return;
//        }
//
//        // 파이프 상태가 가로이거나 대각선일 경우,
//        if (stat == 1 || stat == 3) {
//            if (y + 1 < N && arr[x][y + 1] != 1) {
//                dfs(x, y+1, 1);
//            }
//        }
//
//        // 파이프 상태가 세로이거 대각선일 경우,
//        if (stat == 2 || stat == 3) {
//            if (x + 1 < N && arr[x + 1][y] != 1) {
//                dfs(x+1, y, 2);
//            }
//        }
//
//        // 파이프 상태가 대각선일 경우,
//        if (x + 1 < N && y + 1 < N && arr[x + 1][y + 1] != 1 && arr[x][y + 1] != 1 && arr[x + 1][y] != 1) {
//            dfs(x+1, y+1, 3);
//        }
//    }
//}
