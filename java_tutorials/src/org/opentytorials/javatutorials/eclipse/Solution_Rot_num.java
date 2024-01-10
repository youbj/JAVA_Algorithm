//package org.opentytorials.javatutorials.eclipse;
//
//
//import java.util.Scanner;
//import java.io.FileInputStream;
//import java.lang.*;
///*
//아래->위
//오른쪽->왼쪽
//위->아래
//*/
//
//class Solution
//{
//    public static String checkA(int [][] arr, int n, int t){
//        System.out.println(" ");
//        String str="";
//        for(int i=t-1;i>=0;i--){ // 2 1 0
//            str+=Integer.toString(arr[i][n]);
//        }
//        return str;
//    }
//    
//    public static String checkB(int [][] arr,int n, int t){
//        String str="";
//        for(int i=t-1;i>=0;i--){
//            str+=Integer.toString(arr[t-1-n][i]);
//        }        
//        return str;
//    }
//    
//    public static String checkC(int [][] arr, int n, int t){
//        String str="";
//        for(int i=0;i<t;i++){
//            str+=Integer.toString(arr[i][t-1-n]);
//        }       
//        return str;
//    }    
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
//            int [][] arr=new int[t][t];
//            for(int i=0;i<t;i++){
//                for(int j=0;j<t;j++){
//                    int a=sc.nextInt();
//                    arr[i][j]=a;
//                }
//            }
//            
//			for(int i=0;i<t;i++){
//                String str1=checkA(arr,i,t);
//                String str2=checkB(arr,i,t);
//                String str3=checkC(arr,i,t);
//                System.out.println(str1 + " " + str2 + " " + str3);
//            }
//			
//		}
//	}
//}