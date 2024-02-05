import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author 유병주 
 * @date  02.05
 * @link  https://www.acmicpc.net/problem/2493
 * @keyword_solution  
 * n과 k가 최대 50만까지 입력가능하기 때문에 시간과 공간 복잡도를 잘 따져봐야한다.
 * 1. 해당 인덱스를 저장받아 뒤에서부터 진행하여 배열을 모두 도는 방식 사용 -> 시간초과
 * 2. Stack을 사용하여 입력받은 배열을 뒤에서 모두 도는 방식 사용 -> 시간초과
 * 3. stack을 사용하되 입력받을 배열을 모두 도는 것이 아닌 입력 받을 시, 입력되어있는 값들과 비교를
 * 통해 출력
 * @input 
 * n과 k 그리고 n개의 tower의 높이가 입력된다.
 * @output   
 * 값을 한번에 출력해야 하므로 StringBuilder사용
 * @time_complex  
 * O(n^2)
 * @perf 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek().height >= height) {
                    answer.append(stack.peek().index).append(" ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer.append("0 ");
            }

            stack.push(new Tower(i, height));
        }

        System.out.println(answer.toString().trim());
    }

    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}