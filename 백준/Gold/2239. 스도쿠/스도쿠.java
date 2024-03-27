import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static int[][] sudoku = new int[9][9];
	public static boolean flag = false; 

	public static void main(String[] args) throws Exception {
		int[][] clonemap = new int[9][9];
		int countZero = 0;
		for (int r = 0; r < 9; r++) {
			String numbers = br.readLine();

			for (int c = 0; c < 9; c++) {
				sudoku[r][c] = numbers.charAt(c) - '0';
				clonemap[r][c] = sudoku[r][c];
				if (sudoku[r][c] == 0)
					countZero++;
			}
		}
		makeSudoku(clonemap,countZero);
		System.out.println(sb.toString());
	}

	public static void makeSudoku(int[][] clonemap,int remainZero) {
		if(remainZero==0) {
			flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(clonemap[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		if(flag) return;

		for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (clonemap[i][j] == 0) {
	                for (int value = 1; value <= 9; value++) {
	                    if (checkCol(j, value, clonemap) && checkRow(i, value, clonemap) && checkMatrix(i, j, value, clonemap)) {
	                        clonemap[i][j] = value;

	                        makeSudoku(clonemap, remainZero - 1);

	                        clonemap[i][j] = 0;
	                        	
	                    }
	                }
	                return;
	            }
	            
	        }      
	        
	    }
	}

	public static boolean checkMatrix(int r, int c, int value,int [][]clonemap) {
		int rowStart = (r / 3) * 3;
		int colStart = (c / 3) * 3;

		for (int row = rowStart; row < rowStart + 3; row++) {
			for (int col = colStart; col < colStart + 3; col++) {
				if (clonemap[row][col] == value)
					return false;
			}
		}

		return true;
	}

	public static boolean checkCol(int c, int value,int[][]clonemap) {
		for (int i = 0; i < 9; i++) {
			if (clonemap[i][c] == value)
				return false;
		}
		return true;
	}

	public static boolean checkRow(int r, int value,int[][]clonemap) {
		for (int i = 0; i < 9; i++) {
			if (clonemap[r][i] == value)
				return false;
		}
		return true;
	}

}