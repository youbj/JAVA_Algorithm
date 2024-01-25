import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Answer {
        String str;
        int dist;

        Answer(String str, int dist) {
            this.str = str;
            this.dist = dist;
        }

        public String getStr() {
            return str;
        }

        public int getDist() {
            return dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            String std_input = st.nextToken();
            int test_case = Integer.parseInt(st.nextToken());
            Answer[] answer = new Answer[test_case];

            for (int j = 0; j < test_case; j++) {
                String test_input = br.readLine();
                answer[j] = new Answer(test_input, 0);
            }

            check_locate(answer, std_input);

            Arrays.sort(answer, Comparator.comparing(Answer::getDist).thenComparing(Answer::getStr));

            for (Answer a : answer) {
                System.out.println(a.str + " " + a.dist);
            }
        }
    }

    static String[] keyboard = {"qwertyuiop", "asdfghjkl ", "zxcvbnm   "};

    public static void check_locate(Answer[] answer, String std_input) {
        for (int i = 0; i < std_input.length(); i++) {
            char key = std_input.charAt(i);
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < keyboard[j].length(); k++) {
                    if (keyboard[j].charAt(k) == key) {
                        check_count(answer, j, k, i, key);
                        break;
                    }
                }
            }
        }
    }

    public static void check_count(Answer[] answer, int x, int y, int index, char key) {
        for (int i = 0; i < answer.length; i++) {
            char ans = answer[i].str.charAt(index);
            if (ans == key)
                continue;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < keyboard[j].length(); k++) {
                    if (keyboard[j].charAt(k) == ans) {
                        answer[i].dist += Math.abs(x - j) + Math.abs(y - k);
                        break;
                    }
                }
            }
        }
    }
}