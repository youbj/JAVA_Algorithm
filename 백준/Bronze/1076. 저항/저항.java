import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer[]> ohm = new HashMap<>();
        ohm.put("black", new Integer[]{0, 1});
        ohm.put("brown", new Integer[]{1, 10});
        ohm.put("red", new Integer[]{2, 100});
        ohm.put("orange", new Integer[]{3, 1000});
        ohm.put("yellow", new Integer[]{4, 10000});
        ohm.put("green", new Integer[]{5, 100000});
        ohm.put("blue", new Integer[]{6, 1000000});
        ohm.put("violet", new Integer[]{7, 10000000});
        ohm.put("grey", new Integer[]{8, 100000000});
        ohm.put("white", new Integer[]{9, 1000000000});


        String first = br.readLine();
        int firstInt = ohm.get(first)[0] * 10;
        String second = br.readLine();
        int secondInt = ohm.get(second)[0];
        String third = br.readLine();
        int thirdInt = ohm.get(third)[1];
        long answer = (long) (firstInt + secondInt) * thirdInt;
        System.out.println(answer);

    }
}