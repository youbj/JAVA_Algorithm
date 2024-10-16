import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(words, begin, target);
    }
    
    public int bfs(String[] words, String begin, String target) {
        Queue<Word> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Word(begin, 0));
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            Word now = queue.poll();
            
            if (now.s.equals(target)) {
                return now.cnt;
            }
            
            for (String word : words) {
                if (!visited.contains(word) && compared(word, now.s)) {
                    visited.add(word);
                    queue.offer(new Word(word, now.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean compared(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt == 1;
    }
    
    public class Word {
        String s;
        int cnt;
        public Word(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
}