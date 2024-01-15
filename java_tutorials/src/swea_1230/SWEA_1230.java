//package swea_1230;
//
//import java.util.*;
//import java.io.*;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//// [S/W 문제해결 기본] 8일차 - 암호문3 
//public class SWEA_1230 {
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		LinkedList<String> list;
//		for (int t = 1; t <= 10; t++) {
//			list = new LinkedList<>();
//			br.readLine(); // 원본 암호문의 길이
//			st = new StringTokenizer(br.readLine(), " ");// 원본 암호문
//			while (st.hasMoreTokens()) {
//				list.add(st.nextToken());
//			}
//
//			br.readLine(); // 명령어의 개수
//			st = new StringTokenizer(br.readLine(), " "); // 명령어
//			int x, y;
//			while (st.hasMoreTokens()) {
//				switch (st.nextToken()) {
//				case "I":
//					// I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.
//					x = Integer.parseInt(st.nextToken());
//					y = Integer.parseInt(st.nextToken());
//					for (int i = 0; i < y; i++) {
//						list.add(x++, st.nextToken());
//					}
//					break;
//				case "D":
//					// D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
//					x = Integer.parseInt(st.nextToken());
//					y = Integer.parseInt(st.nextToken());
//					for (int i = 0; i < y; i++) {
//						list.remove(x);
//					}
//					break;
//				case "A":
//					// A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다.
//					y = Integer.parseInt(st.nextToken());
//					for (int i = 0; i < y; i++) {
//						list.add(st.nextToken());
//					}
//					break;
//				}
//			}
//
//			System.out.print("#" + t);
//			for (int i = 0; i < 10; i++) {
//				System.out.print(" " + list.get(i));
//			}
//			System.out.println();
//		}
//
//	}
//
//}