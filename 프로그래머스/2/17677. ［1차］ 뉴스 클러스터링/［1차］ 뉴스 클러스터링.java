import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeFreqMap(str1.toLowerCase());
        Map<String, Integer> map2 = makeFreqMap(str2.toLowerCase());

        int intersectSize = 0;
        int unionSize = 0;

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersectSize += Math.min(map1.get(key), map2.get(key));
            }
        }

        Map<String, Integer> unionMap = new HashMap<>(map1);
        for (String key : map2.keySet()) {
            unionMap.put(key, Math.max(unionMap.getOrDefault(key, 0), map2.get(key)));
        }
        for (int value : unionMap.values()) {
            unionSize += value;
        }

        double jaccard = unionSize == 0 ? 1 : (double) intersectSize / unionSize;
        return (int) (jaccard * 65536);
    }

    private Map<String, Integer> makeFreqMap(String str) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                String key = "" + first + second;
                freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
            }
        }
        return freqMap;
    }
}
