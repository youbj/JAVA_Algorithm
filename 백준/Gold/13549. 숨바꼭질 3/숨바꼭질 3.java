import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int subin;
    static int bro;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        bro = sc.nextInt();
        visited = new boolean[100001];

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<Finder> queue = new LinkedList<>();
        queue.offer(new Finder(subin, 0));
        visited[subin] = true;

        while (!queue.isEmpty()) {
        	Finder current = queue.poll();
            int position = current.pos;
            int time = current.count;

            if (position == bro) {
                return time;
            }

            if (position * 2 <= 100000 && !visited[position * 2]) {
                queue.offer(new Finder(position * 2, time));
                visited[position * 2] = true;
            }

            if (position - 1 >= 0 && !visited[position - 1]) {
                queue.offer(new Finder(position - 1, time + 1));
                visited[position - 1] = true;
            }

            if (position + 1 <= 100000 && !visited[position + 1]) {
                queue.offer(new Finder(position + 1, time + 1));
                visited[position + 1] = true;
            }
        }

        return -1; 
    }
    static class Finder{
    	int pos;
    	int count;
    	
    	Finder(){}
    	Finder(int pos,int count){
    		this.pos=pos;
    		this.count=count;
    	}
    }
}