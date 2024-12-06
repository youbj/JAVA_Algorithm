import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = picks[0] + picks[1] + picks[2];

        int maxMinerals = Math.min(minerals.length, totalPicks * 5);

        List<int[]> sections = new ArrayList<>();

        for(int i = 0; i < maxMinerals; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < Math.min(i + 5, maxMinerals); j++) {
                if(minerals[j].equals("diamond")) dia++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
            }
            sections.add(new int[]{dia, iron, stone});
        }

        Collections.sort(sections, (a, b) -> {
            int scoreA = a[0] * 25 + a[1] * 5 + a[2];
            int scoreB = b[0] * 25 + b[1] * 5 + b[2];
            return scoreB - scoreA;
        });

        int pickIdx = 0; 
        for(int[] section : sections) {
            
            while(pickIdx < 3 && picks[pickIdx] == 0) {
                pickIdx++;
            }

            if(pickIdx == 3) break;

            if(pickIdx == 0) { 
                answer += section[0] + section[1] + section[2];
            } else if(pickIdx == 1) { 
                answer += section[0] * 5 + section[1] + section[2];
            } else {
                answer += section[0] * 25 + section[1] * 5 + section[2];
            }
            
            picks[pickIdx]--; 
        }
        
        return answer;
    }
}