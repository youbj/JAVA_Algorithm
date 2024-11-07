import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        ArrayList<File> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
            String str = files[i];
            String head = "";
            String number = "";
            int idx = 0;

            while(idx < str.length()) {
                if(Character.isDigit(str.charAt(idx))) break;
                head += str.charAt(idx);
                idx++;
            }

            while(idx < str.length() && Character.isDigit(str.charAt(idx)) && number.length() < 5) {
                number += str.charAt(idx);
                idx++;
            }
            
            list.add(new File(head.toLowerCase(), Integer.parseInt(number), str));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).str;
        }
        return answer;
    }
    
    public class File implements Comparable<File> {
        String head;
        int num;
        String str;
        
        public File(String head, int num, String str) {
            this.head = head;
            this.num = num;
            this.str = str;
        }
        
        @Override
        public int compareTo(File o) {
            if(this.head.equals(o.head)) {
                return Integer.compare(this.num, o.num);
            }
            return this.head.compareTo(o.head);
        }
    }
}