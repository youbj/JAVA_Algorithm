import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testcase = Integer.parseInt(br.readLine());
        int n;

        for (int tc = 1; tc <= testcase; tc++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String comm = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                switch (comm) {
                    case "I":
                        map.put(value, map.getOrDefault(value, 0) + 1);
                        break;
                    case "D":
                        if (map.isEmpty())
                            continue;
                        if (value == -1) {
                            int minKey = map.firstKey();
                            if (map.get(minKey) == 1) {
                                map.remove(minKey);
                            } else {
                                map.put(minKey, map.get(minKey) - 1);
                            }
                        }
                        if (value == 1) {
                            int maxKey = map.lastKey();
                            if (map.get(maxKey) == 1) {
                                map.remove(maxKey);
                            } else {
                                map.put(maxKey, map.get(maxKey) - 1);
                            }
                        }
                        break;
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close(); // BufferedReader를 닫습니다.
    }
}