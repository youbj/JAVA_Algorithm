import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = discount.length;
        
        HashMap<String,Integer> wants = new HashMap<>();
        HashMap<String,Integer> disc = new HashMap<>();
        
        for(int i=0;i<want.length;i++){
            wants.put(want[i],number[i]);
        }    

        for(int i=0;i<10;i++){
            disc.put(discount[i], disc.getOrDefault(discount[i], 0) + 1);
        }

        if(isOk(wants,disc)){    
            answer++;
        }

        for(int i=0;i<=size-11;i++){ 
            String remover = discount[i];
            if(disc.get(remover)==1){
                disc.remove(remover);
            }
            else{
                disc.put(remover,disc.get(remover)-1);
            }

            String adder = discount[i+10];
            disc.put(adder, disc.getOrDefault(adder, 0) + 1);

            if(isOk(wants,disc)){    
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isOk(HashMap<String,Integer> w, HashMap<String,Integer> d){
        for(String str:w.keySet()){
            if(!d.containsKey(str) || w.get(str) != d.get(str)){
                return false;
            }
        }
        return true;
    }
}