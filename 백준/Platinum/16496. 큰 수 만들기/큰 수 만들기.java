import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static String answer;
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            String value = st.nextToken();
            list.add(value);
        }

        Collections.sort(list, (o1, o2) -> {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        });

        StringBuilder sb = new StringBuilder();
        for (String num : list) {
            sb.append(num);
        }

        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        System.out.println(answer);
    }
}