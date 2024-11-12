class Solution {
    public int solution(int[] arrayA, int[] arrayB) {        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int answerA = checkDivisor(gcdA, arrayB); 
        int answerB = checkDivisor(gcdB, arrayA); 
        
        return Math.max(answerA, answerB);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int checkDivisor(int gcd, int[] array) {
        if (gcd == 1) return 0; 
        for (int num : array) {
            if (num % gcd == 0) return 0;
        }
        return gcd;
    }
}