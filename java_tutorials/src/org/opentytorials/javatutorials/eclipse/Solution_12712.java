package org.opentytorials.javatutorials.eclipse;

import java.util.*;

public class Solution_12712 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int m,n;
            m=sc.nextInt(); n=sc.nextInt();
            int [][] arr=new int[m][m];
            
            int [] max_one=new int[4];
			int [] max_two=new int[4];
            
			for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                	int num=sc.nextInt();
                    arr[i][j]=num;
                }
            }
            //+ 형 -> 위 아래 오 왼
			
            
            //X 형 -> 대각 오른쪽 위(i-1, j-1) , 대각 왼쪽 위(i+1, j-1), 대각 오른쪽 아래 (i-1, j+1), 대각왼쪽 아래 (i+1, j+1)
            System.out.println("#"+test_case+" "+answer);
		}
	}
}
