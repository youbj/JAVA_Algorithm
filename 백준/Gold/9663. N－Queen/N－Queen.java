import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static long cnt=0;
	static int[] queenPosition;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n= sc.nextInt();
        queenPosition=new int[n];
        
        dfs(n, 0);
        System.out.println(cnt);
        
        sc.close();
    }

    private static void dfs(int n, int row) {
        if (row == n) {
        	cnt++;
            return;
        }
        for (int col = 0; col < n; col++) {
        	queenPosition[row]=col;
        	
            if (positionChecking(row)) {
                dfs(n, row + 1);              
            }
        }
    }

    private static boolean positionChecking(int x) {
        for (int i=0;i<x; i++) {
            if (queenPosition[i] == queenPosition[x] || Math.abs(queenPosition[i] - queenPosition[x]) == x-i) {
                return false;
            }
        }
        return true;
    }
}