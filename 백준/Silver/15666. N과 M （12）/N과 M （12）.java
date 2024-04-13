import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers; // 입력 받은 숫자들을 저장할 배열
    static int[] selected; // 현재까지 선택된 숫자들을 저장할 배열
    static StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers); // 입력 받은 숫자들 정렬

        backtrack(0, 0);
        System.out.print(sb);
    }

    // 백트래킹을 이용한 함수, start는 선택 시작 위치, depth는 현재까지 선택된 숫자의 개수
    static void backtrack(int start, int depth) {
        if (depth == M) { // M개를 모두 선택한 경우
            for (int val : selected) {
                sb.append(val).append(' '); // StringBuilder에 추가
            }
            sb.append('\n');
            return;
        }

        int lastSelected = -1; // 이전에 선택된 숫자 저장 (중복 제거용)
        for (int i = start; i < N; i++) {
            if (lastSelected != numbers[i]) { // 이전에 선택된 숫자와 다른 경우에만 선택
                selected[depth] = numbers[i];
                backtrack(i, depth + 1); // 다음 숫자 선택을 위해 재귀 호출
                lastSelected = numbers[i]; // 현재 숫자를 이전에 선택된 숫자로 저장
            }
        }
    }
}