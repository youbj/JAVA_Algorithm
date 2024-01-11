package programmers_newscluster;

import java.util.*;
import java.lang.*;
public class News_Cluster {

	
	public static int solution(String str1, String str2) {
	    int answer = 1;
	    str1 = str1.toUpperCase();
	    str2 = str2.toUpperCase();
	    String[] str_arr1 = new String[str1.length() - 1];
	    String[] str_arr2 = new String[str2.length() - 1];

	    for (int i = 0; i < str1.length() - 1; i++) {
	        char c1 = str1.charAt(i);
	        char c2 = str1.charAt(i + 1);
	        if (c1 > 'Z' || c1 < 'A' || c2 > 'Z' || c2 < 'A') {
	            continue;
	        }
	        str_arr1[i] = str1.substring(i, i + 2);
	    }
	    for (int i = 0; i < str2.length() - 1; i++) {
	        char c1 = str2.charAt(i);
	        char c2 = str2.charAt(i + 1);
	        if (c1 > 'Z' || c1 < 'A' || c2 > 'Z' || c2 < 'A') {
	            continue;
	        }
	        str_arr2[i] = str2.substring(i, i + 2);
	    }

	    

	    return answer;
	}

	public static void main(String[] args) {
	    solution("FRANCE", "french");
	}


}
