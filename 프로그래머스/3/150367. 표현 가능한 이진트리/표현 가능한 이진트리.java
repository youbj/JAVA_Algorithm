class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int treeHeight = 1;
            int nodeCount = 1;
            while(nodeCount < binary.length()) {
                treeHeight++;
                nodeCount += (1 << (treeHeight - 1));
            }

            while(binary.length() < nodeCount) {
                binary = "0" + binary;
            }
            
            answer[i] = isValidBinaryTree(binary, 0, binary.length() - 1) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean isValidBinaryTree(String binary, int start, int end) {
        if(start > end) return true;
        
        int root = (start + end) / 2;

        if(binary.charAt(root) == '0') {
            for(int i = start; i <= end; i++) {
                if(i != root && binary.charAt(i) == '1') return false;
            }
        }
        
        return isValidBinaryTree(binary, start, root - 1) && 
               isValidBinaryTree(binary, root + 1, end);
    }
}