import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String buf = "";

        for (int i = 0; i < size; i++) {
            buf += "IO";
        }
        buf += "I";

        int answer = 0;
        for (int i = 0; i <= len - buf.length(); i++) {
            String std = str.substring(i, i + buf.length());
            if (buf.equals(std)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}