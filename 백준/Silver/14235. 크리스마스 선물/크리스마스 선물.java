import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<tc;i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==0){
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(que.poll()).append("\n");
                }
            }
            else{
                for(int j=0;j<order;j++){
                    que.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}