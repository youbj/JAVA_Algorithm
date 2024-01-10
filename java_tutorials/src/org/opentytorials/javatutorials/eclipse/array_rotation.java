//package org.opentytorials.javatutorials.eclipse;
//
//import java.util.*;
//import java.lang.*;
//
//public class array_rotation {
//	public static String change_str(int [][] arr, int n, int t){
//        String str="";
//        for(int i=0;i<t;i++){
//            str+=Integer.toString(arr[n][t-1-i]);
//        }
//        return str;
//	}      
//    
//	public static void main(String args[]) throws Exception
//	{
//
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			int t=sc.nextInt();
//            int [][] arr=new int[7][7];
//            for(int i=0;i<t;i++){
//                for(int j=0;j<t;j++){
//                    int a=sc.nextInt();
//                    arr[i][j]=a;
//                }
//            }
//            
//			for(int i=0;i<t;i++){
//                String str1=change_str(arr,i,t);
//     
//                System.out.println(str1);
//            }
//			
//		}
//	}
//}
