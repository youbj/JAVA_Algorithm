import java.util.*;

class Solution {
   public String solution(String m, String[] musicinfos) {
       m = replaceSharp(m);
       String answer = "(None)";
       int maxPlayTime = -1;
       
       for(int i = 0; i < musicinfos.length; i++) {
           String[] info = musicinfos[i].split(",");
           
           String[] startTime = info[0].split(":");
           String[] endTime = info[1].split(":");
           
           int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
           int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
           int playTime = end - start;
           
           String title = info[2];
           String melody = replaceSharp(info[3]);
           
           StringBuilder actualMelody = new StringBuilder();
           for(int j = 0; j < playTime; j++) {
               actualMelody.append(melody.charAt(j % melody.length()));
           }
           
           if(actualMelody.toString().contains(m)) {
               if(playTime > maxPlayTime) {
                   answer = title;
                   maxPlayTime = playTime;
               }
           }
       }
       
       return answer;
   }
   
   private String replaceSharp(String melody) {
       return melody.replace("C#", "c")
                   .replace("D#", "d")
                   .replace("F#", "f")
                   .replace("G#", "g")
                   .replace("B#", "b")
                   .replace("A#", "a");
   }
}