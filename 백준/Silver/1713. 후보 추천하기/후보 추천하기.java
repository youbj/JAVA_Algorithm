import java.io.*;
import java.util.*;

public class Main {
    static class Candidate implements Comparable<Candidate> {
        int id, votes, time;

        public Candidate(int id, int votes, int time) {
            this.id = id;
            this.votes = votes;
            this.time = time;
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.votes == o.votes) {
                return this.time - o.time;
            }
            return this.votes - o.votes;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Candidate> frame = new ArrayList<>();
        Map<Integer, Candidate> inFrame = new HashMap<>();

        for (int time = 0; time < total; time++) {
            int id = Integer.parseInt(st.nextToken());

            if (inFrame.containsKey(id)) {
                inFrame.get(id).votes++;
            } else {
                Candidate newCandidate = new Candidate(id, 1, time);
                if (frame.size() >= N) {
                    Candidate removed = Collections.min(frame);
                    frame.remove(removed);
                    inFrame.remove(removed.id);
                }
                frame.add(newCandidate);
                inFrame.put(id, newCandidate);
            }
        }

        frame.sort((a, b) -> Integer.compare(a.id, b.id));
        for (Candidate c : frame) {
            System.out.print(c.id + " ");
        }
    }
}