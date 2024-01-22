import java.io.*;
import java.util.*;


public class Main {
	static class Point{
		int x,y,dir;
		Point(int x, int y, int dir){
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
	}
	
	public static int count=1;
	public static int m,n;
	public static final int[] dx= {-1,0,1,0};
	public static final int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		
		int r,c,dir; //r,c에 위치하며 항상 0, 
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		dir= Integer.parseInt(st.nextToken());
		Point start=new Point(r,c,dir);
		
		int [][] map=new int[n][m];
		boolean [][] map_wall=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					map_wall[i][j]=true;
				}
			}
		}
		Vacuum_route(map,map_wall,start);
		System.out.println(count);
		
		
	}

	public static void Vacuum_route(int[][] map,boolean [][]map_wall, Point start) {
		Queue<Point> que=new LinkedList<>();
		que.offer(start);
		map[start.x][start.y]=1;
		
		while(!que.isEmpty()) {
			Point now_location=que.poll();

			boolean route_check=false;
			
			for(int i=0;i<4;i++) { // 4방향 중 빈칸 확인
				int nx= now_location.x+dx[i];
				int ny= now_location.y+dy[i];
							
				if(map[nx][ny]==0&&map_scope(nx, ny)) {				
					route_check=true;
					break;
				}
			}
			
			if(route_check) {// 4방향 중 빈 칸이 있는 경우			
				int next_Act= (now_location.dir+3)%4;
				int nx= now_location.x+dx[next_Act];
				int ny= now_location.y+dy[next_Act];
				
				if(map_scope(nx,ny)&&map_wall[nx][ny]==false&&map[nx][ny]==0) {			
					map[nx][ny]=1;
					count++;
//					System.out.println(dirs[next_Act]+"쪽으로 이동");
					que.offer(new Point(nx,ny,next_Act));
				}
				else {			
					que.offer(new Point(now_location.x,now_location.y,next_Act));
				}
				
			}
			else {// 4방향 중 빈칸이 없는경우
				int next_Act= (now_location.dir+2)%4;
				int nx= now_location.x+dx[next_Act];
				int ny= now_location.y+dy[next_Act];
				
				if(!map_wall[nx][ny])
					que.offer(new Point(nx,ny,now_location.dir));
				else
					return ;
			}
		}
	}
	
	public static boolean map_scope(int nx,int ny) {
		if(nx<0||nx>=n||ny<0||ny>=m) {
			return false;
		}
		return true;
	}

}