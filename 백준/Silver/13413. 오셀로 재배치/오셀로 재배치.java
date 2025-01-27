import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int ts = Integer.parseInt(br.readLine());

        for(int t = 0; t < ts; t++) {
            int len = Integer.parseInt(br.readLine());
            String current = br.readLine();
            String target = br.readLine();

            int bToW = 0;
            int wToB = 0;

            for(int i = 0; i < len; i++) {
                char curr = current.charAt(i);
                char targ = target.charAt(i);

                if(curr!=targ){
                    if(curr=='B'){
                        bToW++;
                    }
                    else{
                        wToB++;
                    }
                }
            }

            sb.append(Math.max(bToW, wToB)).append('\n');
        }
        System.out.print(sb);
    }
}