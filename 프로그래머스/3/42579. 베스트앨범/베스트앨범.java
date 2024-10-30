import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalPlays = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> songs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            
            songs.putIfAbsent(genres[i], new PriorityQueue<>());
            songs.get(genres[i]).add(new Song(i, plays[i], genres[i]));
        }

        PriorityQueue<Genre> genreQueue = new PriorityQueue<>();
        for(String genre : totalPlays.keySet()) {
            genreQueue.add(new Genre(genre, totalPlays.get(genre)));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!genreQueue.isEmpty()) {
            String genre = genreQueue.poll().genre;
            PriorityQueue<Song> songQueue = songs.get(genre);

            int count = 0;
            while(!songQueue.isEmpty() && count < 2) {
                answer.add(songQueue.poll().idx);
                count++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public class Genre implements Comparable<Genre> {
        String genre;
        int totalCnt;
        
        public Genre(String genre, int totalCnt) {
            this.genre = genre;
            this.totalCnt = totalCnt;
        }
        
        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.totalCnt, this.totalCnt); 
        }
    }
    
    public class Song implements Comparable<Song> {
        int idx, cnt;
        String genre;
        
        public Song(int idx, int cnt, String genre) {
            this.idx = idx;
            this.cnt = cnt;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Song o) {
            if(this.cnt == o.cnt) {
                return Integer.compare(this.idx, o.idx); 
            }
            return Integer.compare(o.cnt, this.cnt); 
        }
    }
}