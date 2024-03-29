import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken().charAt(0));
		}
		System.out.println(sb.toString());
	}
}