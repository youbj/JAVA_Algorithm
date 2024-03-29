import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static List<Integer> list = new ArrayList<>();

	
    public static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0; 

        computeLPSArray(pat, M, lps);

        int i = 0; 
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
            	list.add((i - j)+1);
            	sb.append((i - j)+1).append("\n");
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i = i + 1;
            }
        }
    }

    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0; 

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception{
    	
        String txt = br.readLine();
        String pat = br.readLine();
        KMPSearch(pat, txt);

        System.out.println(list.size());
        System.out.println(sb.toString());
    }
    
}