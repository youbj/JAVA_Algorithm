package swea_1247;

import java.io.*;
import java.util.*;

class Customer{
	int x;
	int y;
	public Customer(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_1247 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			int com_x, com_y;
			com_x=sc.nextInt(); com_y=sc.nextInt();
			
			int home_x, home_y;
			home_x=sc.nextInt(); home_y=sc.nextInt();
			
			Customer[] address=new Customer[n];			
			for(int i=0;i<n*2;i++) {
				int x,y;
				x=sc.nextInt(); y=sc.nextInt();
				address[i/2].x=x; address[i/2].y=y;
			}
			
		}
	}
}
