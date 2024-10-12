import java.util.*;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return cities.length*5;
        }
        int answer = 0;
        LinkedList<String> cash = new LinkedList<>();
        
        if(cities.length!=0){
            cash.add(cities[0].toUpperCase());
            answer+=5;
        }
        
        for(int i=1;i<cities.length;i++){
            String city = cities[i].toUpperCase();
            int index = cash.indexOf(city);
            if(index!=-1){
                cash.remove(index);
                answer+=1;
            }
            else{
                if(cash.size()==cacheSize){
                    cash.removeFirst();
                }
                answer+=5;
            }
            cash.add(city);
        }
        
        return answer;
    }
}