import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] A = new int[N];
        Element[] elements = new Element[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            elements[i] = new Element(A[i], i);
        }
        
        Arrays.sort(elements);
        
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[elements[i].index] = i;
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
    
    static class Element implements Comparable<Element> {
        int value;
        int index;
        
        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }
}