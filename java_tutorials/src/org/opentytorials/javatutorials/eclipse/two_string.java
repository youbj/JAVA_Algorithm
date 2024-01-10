//package org.opentytorials.javatutorials.eclipse;
//
//import java.util.*;
//
//
//public class two_string {
//	
//	public static void main(String args[]) throws Exception
//	{
//		
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//		
//
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			int a,b;
//            a=sc.nextInt(); b=sc.nextInt();
//            
//			int A,B; //A=작은거 B=큰거  
//            if(a<b){
//                A=b; B=a;
//            }
//            else {
//                A=a; B=b;
//            }
//            int [] a_arr=new int[a];
//            int [] b_arr=new int[b];
//            
//			for(int i=0;i<a;i++){
//                int n=sc.nextInt();
//                a_arr[i]=n;
//            }
//            
//            for(int i=0;i<b;i++){
//                int n=sc.nextInt();
//                b_arr[i]=n;
//            }
//            
//            int [] A_arr=new int[A];
//            int [] B_arr=new int[B];
//            
//            if(a<b) {
//            	A_arr=a_arr;
//            	B_arr=b_arr;
//            }
//            else {
//            	A_arr=b_arr;
//            	B_arr=a_arr;           	
//            }
//            
//            int sum_max=-1;
//            for(int i=0;i<=B-A;i++) {
//            	int sum=0;
//            	for(int j=i;j<A;j++) {
//            		sum+=(A_arr[j]*b_arr[j+i]);
//            	}
//            	if(sum_max<sum)
//            		sum_max=sum;
//            }
//            
//            System.out.println("#"+test_case+" "+sum_max);
//            
//		}
//	}
//}
