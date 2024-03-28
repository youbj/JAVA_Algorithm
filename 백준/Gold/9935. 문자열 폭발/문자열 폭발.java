import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 원본 문자열
        String bomb = br.readLine(); // 폭발 문자열
        char lastChar = bomb.charAt(bomb.length() - 1); // 폭발 문자열의 마지막 문자
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            // 폭발 문자열의 마지막 문자와 현재 문자가 일치하는 경우
            if (stack.size() >= bomb.length() && stack.peek() == lastChar) {
                boolean isBomb = true;

                // 스택의 상위 문자들이 폭발 문자열과 일치하는지 확인
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열이 확인된 경우, 스택에서 해당 문자들을 제거
                if (isBomb) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}